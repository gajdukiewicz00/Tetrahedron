package com.epam.tetrahedron.observer;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.warehouse.TetrahedronParameters;
import com.epam.tetrahedron.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarehouseObserver implements TetrahedronObserver {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseObserver.class);
    private final TetrahedronService service = new TetrahedronService();

    @Override
    public void update(TetrahedronEvent event) throws TetrahedronException {
        Tetrahedron tetrahedron = event.getSource();
        long id = tetrahedron.getId();

        logger.info("Observer triggered for tetrahedron id: {}", id);

        try {
            double volume = service.calculateVolume(tetrahedron);
            double surfaceArea = service.calculateSurfaceArea(tetrahedron);
            TetrahedronParameters parameters = new TetrahedronParameters(volume, surfaceArea);

            Warehouse.getInstance().put(id, parameters);
            logger.info("Updated warehouse for tetrahedron id: {} with parameters: {}", id, parameters);
        } catch (TetrahedronException e) {
            logger.error("Failed to update warehouse for tetrahedron id: {}", id, e);
            throw e;
        }
    }
}
