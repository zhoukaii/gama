package ummisco.gama.serializer.gamaType.reduced;

import msi.gama.metamodel.topology.graph.GamaSpatialGraph;
import msi.gama.runtime.IScope;
import msi.gama.util.GamaMap;
import msi.gama.util.graph.GamaGraph;
import msi.gaml.types.GamaGraphType;
import msi.gaml.types.IType;

@SuppressWarnings({ "rawtypes" })
public class GamaGraphReducer {
	private final IType keyTypeGraphReducer;
	private final IType contentTypeGraphReducer;

	private final GamaMap valuesGraphReducer;
	private final boolean spatial;

	public GamaGraphReducer(final IScope scope, final GamaGraph g) {
		spatial = g instanceof GamaSpatialGraph;
		keyTypeGraphReducer = g.getType().getKeyType();
		contentTypeGraphReducer = g.getType().getContentType();

		valuesGraphReducer = g.mapValue(scope, keyTypeGraphReducer, contentTypeGraphReducer, false);
	}

	public GamaGraph constructObject(final IScope scope) {
		return (GamaGraph) GamaGraphType.from(scope, valuesGraphReducer, spatial);
	}
}
