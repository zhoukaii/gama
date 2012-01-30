/*
 * GAMA - V1.4 http://gama-platform.googlecode.com
 * 
 * (c) 2007-2011 UMI 209 UMMISCO IRD/UPMC & Partners (see below)
 * 
 * Developers :
 * 
 * - Alexis Drogoul, UMI 209 UMMISCO, IRD/UPMC (Kernel, Metamodel, GAML), 2007-2012
 * - Vo Duc An, UMI 209 UMMISCO, IRD/UPMC (SWT, multi-level architecture), 2008-2012
 * - Patrick Taillandier, UMR 6228 IDEES, CNRS/Univ. Rouen (Batch, GeoTools & JTS), 2009-2012
 * - Beno�t Gaudou, UMR 5505 IRIT, CNRS/Univ. Toulouse 1 (Documentation, Tests), 2010-2012
 * - Phan Huy Cuong, DREAM team, Univ. Can Tho (XText-based GAML), 2012
 * - Pierrick Koch, UMI 209 UMMISCO, IRD/UPMC (XText-based GAML), 2010-2011
 * - Romain Lavaud, UMI 209 UMMISCO, IRD/UPMC (RCP environment), 2010
 * - Francois Sempe, UMI 209 UMMISCO, IRD/UPMC (EMF model, Batch), 2007-2009
 * - Edouard Amouroux, UMI 209 UMMISCO, IRD/UPMC (C++ initial porting), 2007-2008
 * - Chu Thanh Quang, UMI 209 UMMISCO, IRD/UPMC (OpenMap integration), 2007-2008
 */
package msi.gama.gui.displays;

import java.awt.image.BufferedImage;
import java.util.*;
import msi.gama.common.interfaces.*;
import msi.gama.common.util.ImageUtils;
import msi.gama.gui.parameters.*;
import msi.gama.metamodel.agent.IAgent;
import msi.gama.metamodel.population.IPopulation;
import msi.gama.metamodel.shape.IShape;
import msi.gama.metamodel.topology.grid.GamaSpatialMatrix;
import msi.gama.outputs.layers.*;
import msi.gama.runtime.*;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gaml.commands.*;
import msi.gaml.species.ISpecies;
import org.eclipse.swt.widgets.Composite;
import com.vividsolutions.jts.geom.Envelope;

/**
 * Written by drogoul Modified on 23 août 2008
 */

public class SpeciesDisplay extends AgentDisplay {

	public SpeciesDisplay(final double env_width, final double env_height,
		final IDisplayLayer layer, final IGraphics dg) {
		super(env_width, env_height, layer, dg);
	}

	@Override
	public void fillComposite(final Composite compo, final IDisplaySurface container) {
		super.fillComposite(compo, container);
		EditorFactory.choose(compo, "Aspect:", ((SpeciesDisplayLayer) model).getAspectName(), true,
			((SpeciesDisplayLayer) model).getAspects(), new EditorListener<String>() {

				@Override
				public void valueModified(final String newValue) {
					changeAspect(newValue);
					container.updateDisplay();
				}
			});
	}

	@Override
	public Set<IAgent> getAgentsForMenu() {
		return new HashSet(GAMA.getDefaultScope().getWorldScope()
			.getMicroPopulation(((SpeciesDisplayLayer) model).getSpecies()).getAgentsList());
	}

	private void changeAspect(final String s) {
		((SpeciesDisplayLayer) model).setAspect(s);
	}

	@Override
	public String getType() {
		return "Species layer";
	}

	@Override
	public void privateDrawDisplay(final IGraphics g) throws GamaRuntimeException {
		// performance issue
		// List<IAgent> agentsToDisplay = new GamaList<IAgent>(getAgentsToDisplay());
		// if ( agentsToDisplay.isEmpty() ) { return; }

		shapes.clear();
		IScope scope = GAMA.obtainNewScope();
		if ( scope != null ) {

			// TODO search for hostPopulations then recursively draw micro-grid-populations and
			// micro-populations

			// start drawing agents of "level 1" species ...
			ISpecies species = ((SpeciesDisplayLayer) model).getSpecies();
			if ( species.getLevel() == 1 ) {
				IAgent world = scope.getWorldScope();
				IPopulation microPop = world.getMicroPopulation(species);
				if ( microPop != null ) {
					scope.setContext(g);
					drawPopulation(world, (SpeciesDisplayLayer) model, microPop, scope, g);
				}
			}

			GAMA.releaseScope(scope);
		}
	}

	/*
	 * // TODO remove
	 * private void drawMicroAgents(IScope scope, IAgent macroAgent, IGraphics g) throws
	 * GamaRuntimeException {
	 * SpeciesDisplayLayer layer = (SpeciesDisplayLayer) model;
	 * List<SpeciesDisplayLayer> microLayers = layer.getMicroSpeciesLayers();
	 * IAspect aspect;
	 * IPopulation microPopulation;
	 * 
	 * // TODO support draw ISpatialIndex/GamaQuadTree of macro-agent's inner environment
	 * 
	 * for (SpeciesDisplayLayer ml : microLayers) {
	 * microPopulation = macroAgent.getMicroPopulation(ml.getName());
	 * 
	 * if (microPopulation != null) {
	 * if (microPopulation.isGrid()) { // TODO remove?
	 * GridTopology gridAgentStorage = (GridTopology) microPopulation.getAgentStorage();
	 * gridAgentStorage.refreshDisplayData();
	 * 
	 * // MUST cache this image as GridDisplayLayer does to increase performance
	 * BufferedImage supportImage = ImageCache.createCompatibleImage(gridAgentStorage.numCols,
	 * gridAgentStorage.numRows);
	 * supportImage.setRGB(0, 0, gridAgentStorage.numCols, gridAgentStorage.numRows,
	 * gridAgentStorage.getDisplayData(), 0, gridAgentStorage.numCols);
	 * 
	 * GamaPoint macroLocation = macroAgent.getLocation();
	 * GamaGeometry macroShape = macroAgent.getGeometry();
	 * double width = macroShape.getWidth();
	 * double height = macroShape.getHeight();
	 * g.setDrawingCoordinates((macroLocation.x - (width / 2)) * g.getXScale(), (macroLocation.y -
	 * (height / 2)) * g.getYScale());
	 * g.setDrawingDimensions((int) (macroShape.getWidth() * g.getXScale()), (int)
	 * (macroShape.getHeight() * g.getYScale()));
	 * g.setOpacity(ml.getTransparency());
	 * g.drawImage(supportImage, null);
	 * } else {
	 * if (microPopulation != null && microPopulation.size() > 0) {
	 * aspect = microPopulation.getAspect(ml.getAspectName());
	 * if (aspect == null) { aspect = IAspect.DEFAULT_ASPECT; }
	 * g.setOpacity(ml.getTransparency());
	 * 
	 * List<IAgent> microAgents = microPopulation.getAgentsList();
	 * for (IAgent micro : microAgents) {
	 * aspect.draw(scope, micro);
	 * }
	 * 
	 * }
	 * }
	 * }
	 * }
	 * }
	 */

	private void drawPopulation(final IAgent host, final SpeciesDisplayLayer layer,
		final IPopulation population, final IScope scope, final IGraphics g)
		throws GamaRuntimeException {
		IAspect aspect = population.getAspect(layer.getAspectName());
		if ( aspect == null ) {
			aspect = AspectCommand.DEFAULT_ASPECT;
		}
		g.setOpacity(layer.getTransparency());

		List<IAgent> _agents = population.getAgentsList();
		if ( !_agents.isEmpty() ) {

			// draw the population
			for ( IAgent a : _agents ) {
				if ( a != null && !a.dead() ) {
					shapes.put(aspect.draw(scope, a), a);
				}
			}

			IPopulation microPop;

			// draw grids first...
			List<GridDisplayLayer> gridLayers = layer.getGridLayers();
			for ( GridDisplayLayer gl : gridLayers ) {
				for ( IAgent a : _agents ) {
					if ( a.acquireLock() ) {
						try {
							microPop = a.getMicroPopulation(gl.getName());

							if ( microPop != null && microPop.size() > 0 ) {
								drawGridPopulation(a, gl, microPop, scope, g);
							}
						} finally {
							a.releaseLock();
						}
					}
				}
			}

			// then recursively draw the micro-populations
			List<SpeciesDisplayLayer> microLayers = layer.getMicroSpeciesLayers();
			for ( SpeciesDisplayLayer ml : microLayers ) {
				for ( IAgent a : _agents ) {
					if ( a.acquireLock() ) {
						try {
							microPop = a.getMicroPopulation(ml.getSpecies());

							if ( microPop != null && microPop.size() > 0 ) {
								drawPopulation(a, ml, microPop, scope, g);
							}
						} finally {
							a.releaseLock();
						}
					}
				}
			}
		}
	}

	private void drawGridPopulation(final IAgent host, final GridDisplayLayer layer,
		final IPopulation population, final IScope scope, final IGraphics g)
		throws GamaRuntimeException {
		GamaSpatialMatrix gridAgentStorage =
			(GamaSpatialMatrix) population.getTopology().getPlaces();
		gridAgentStorage.refreshDisplayData();

		// MUST cache this image as GridDisplayLayer does to increase performance
		BufferedImage supportImage =
			ImageUtils.createCompatibleImage(gridAgentStorage.numCols, gridAgentStorage.numRows);
		supportImage.setRGB(0, 0, gridAgentStorage.numCols, gridAgentStorage.numRows,
			gridAgentStorage.getDisplayData(), 0, gridAgentStorage.numCols);

		IShape hostShape = host.getGeometry();
		// GamaPoint hostLocation = hostShape.getLocation();
		Envelope hostEnv = hostShape.getEnvelope();

		// AffineTransform saved = g.getTransform();

		g.setDrawingCoordinates(hostEnv.getMinX() * g.getXScale(),
			hostEnv.getMinY() * g.getYScale());
		g.setDrawingDimensions((int) (gridAgentStorage.numCols * g.getXScale() * 2),
			(int) (gridAgentStorage.numCols * g.getYScale()));
		g.setOpacity(layer.getTransparency());
		g.drawImage(supportImage, null);

		// System.out.println("xScale = " + g.getXScale() + "; yScale = " + g.getYScale());

		// TODO draw sub grids and sub micro-populations
		//
		// for ( IAgent a : population.getAgentsList() ) {

		// }

	}

	// private void drawSubPopulations() {
	//
	// }
}
