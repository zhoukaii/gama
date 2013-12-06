/**
 *  mapcomparison
 *  Author: Taillandier
 *  Description: 
 */

model mapcomparison

global {
	list<string> categories <- ["type 1", "type 2", "type 3", "type 4"];
	map<string,rgb> color_cat <- ["type 1"::rgb("blue"), "type 2"::rgb("green"), "type 3"::rgb("yellow"), "type 4"::rgb("red")];
	matrix<float> fuzzy_categories;
	list<float> nb_per_cat_obs;
	list<float> nb_per_cat_sim;
	
	init {
		ask shuffle(cell) {
			string neigh_cat <-one_of(neighbours).cat_observed;
			cat_init <- neigh_cat in categories ? neigh_cat : one_of(categories);
			cat_observed <- flip(0.8) ?  cat_init : one_of(categories);
			cat <- flip(0.7) ?  cat_observed : one_of(categories);
			color <- color_cat[cat];
			color_init <- color_cat[cat_init];
			color_obs <- color_cat[cat_observed];
		}
		fuzzy_categories <- 0.0 as_matrix {length(categories),length(categories)};
		loop i from: 0 to: length(categories) - 1 {
			fuzzy_categories[i,i] <- 1.0;
		}
		list<float> similarity_per_agents <- [];
		write "kappa(map observed, map simulation): " + kappa( cell collect (each.cat_observed),cell collect (each.cat),categories);
		write "kappa simulation(map init, map observed, map simulation): " + kappa_sim( cell collect (each.cat_init), cell collect (each.cat_observed),cell collect (each.cat),categories);
		using topology(cell) {
			write "fuzzy kappa(map observed, map simulation): " + fuzzy_kappa(cell, cell collect (each.cat_observed),cell collect (each.cat), similarity_per_agents,categories,fuzzy_categories, 3);
		}
		loop i from: 0 to: length(cell) - 1 {
			int val <- int(255 * similarity_per_agents[i]);
			ask cell[i] {color_fuzzy <- rgb(val, val, val);}
			
		}
		loop c over: categories {
			nb_per_cat_obs << cell count (each.cat_observed = c);
			nb_per_cat_sim << cell count (each.cat = c); 
		}
		write "percent_absolute_deviation : " + percent_absolute_deviation(nb_per_cat_obs,nb_per_cat_sim) + "%";
		
	}
	
}

grid cell width: 50 height: 50 {
	string cat_init;
	string cat_observed;
	string cat ;
	rgb color;
	rgb color_init;
	rgb color_obs;
	rgb color_fuzzy <- rgb("white");
	list<cell> neighbours <- self neighbours_at 1;
	
	aspect fuzzy_sim {
		draw shape color:color_fuzzy border: color_fuzzy;
	}
	aspect init {
		draw shape color:color_init border: color_init;
	}
	aspect observed {
		draw shape color:color_obs border: color_obs;
	}
}

experiment mapcomparison type: gui {
	output {
		display map_sim type: opengl{
			grid cell;
		}
		display map_observed type: opengl{
			species cell aspect: observed refresh: false;
		}
		display map_init type: opengl{
			species cell aspect: init refresh: false;
		}
		display map_fuzzy type: opengl{
			species cell aspect: fuzzy_sim ;
		}
	}
}