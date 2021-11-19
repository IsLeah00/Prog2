module appfuncs {
	//megmondhatjuk, hogy ez a modul mit tesz láthatóvá más modulok számára
	exports appfuncs.simplefuncs;
	//aki használja az tranzitívan tovább fogja adni az appsupportot is
	requires transitive appsupport;
}