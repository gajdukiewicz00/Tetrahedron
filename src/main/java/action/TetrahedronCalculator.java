package action;

import entity.Point;
import entity.Tetrahedron;
import util.LoggerUtil;

public class TetrahedronCalculator {

    public static double calculateVolume(Tetrahedron tetrahedron) {
        LoggerUtil.LOGGER.info("Calculating volume for tetrahedron: " + tetrahedron);
        Point[] vertices = tetrahedron.getVertices();

        double x1 = vertices[0].getX();
        double y1 = vertices[0].getY();
        double z1 = vertices[0].getZ();

        double x2 = vertices[1].getX();
        double y2 = vertices[1].getY();
        double z2 = vertices[1].getZ();

        double x3 = vertices[2].getX();
        double y3 = vertices[2].getY();
        double z3 = vertices[2].getZ();

        double x4 = vertices[3].getX();
        double y4 = vertices[3].getY();
        double z4 = vertices[3].getZ();

        double volume = Math.abs(
                (x2 - x1) * ((y3 - y1) * (z4 - z1) - (z3 - z1) * (y4 - y1)) -
                        (y2 - y1) * ((x3 - x1) * (z4 - z1) - (z3 - z1) * (x4 - x1)) +
                        (z2 - z1) * ((x3 - x1) * (y4 - y1) - (y3 - y1) * (x4 - x1))
        ) / 6.0;

        LoggerUtil.LOGGER.info("Calculated volume: " + volume);
        return volume;
    }
}
