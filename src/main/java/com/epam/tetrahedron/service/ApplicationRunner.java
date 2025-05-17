package com.epam.tetrahedron.service;

import com.epam.tetrahedron.repository.TetrahedronRepository;

public class ApplicationRunner {
    public void run(String inputPath) {
        TetrahedronRepository repository = new TetrahedronRepository();

        TetrahedronImporter importer = new TetrahedronImporter(repository);
        importer.importFromFile(inputPath);

        TetrahedronReporter reporter = new TetrahedronReporter(repository);
        reporter.printWarehouseContents();
        reporter.printLargeTetrahedrons(100.0);
    }
}
