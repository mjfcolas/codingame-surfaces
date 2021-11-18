package fr.li212.codingame.surfaces.domain.finder;

import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;
import fr.li212.codingame.surfaces.domain.models.grid.Grid;

import java.util.*;

public class SurfaceFinderForSmallSurfaces implements SurfaceFinder {

    private final Grid gridToCompute;
    private final Coordinate[][] copiedGrid;

    public SurfaceFinderForSmallSurfaces(final Grid gridToCompute) {
        this.gridToCompute = gridToCompute;
        this.copiedGrid = initialize();
    }

    @Override
    public Set<Coordinate> findSurface(final Coordinate germ) {
        final Set<Coordinate> closedSet = new HashSet<>();
        final Set<Coordinate> completeSurface = new HashSet<>();
        if (!gridToCompute.getCell(germ).isWater()) {
            return Collections.emptySet();
        } else {
            completeSurface.add(germ);
        }
        Coordinate startNode = copiedGrid[germ.getX()][germ.getY()];
        closedSet.add(startNode);
        final Stack<Coordinate> openStack = new Stack<>();
        openStack.add(startNode);
        while (!openStack.isEmpty()) {
            final Coordinate currentNode = openStack.pop();
            final Collection<Coordinate> notClosedNeighbours = this.getNeighbours(currentNode, copiedGrid, closedSet);
            for (Coordinate neighbour : notClosedNeighbours) {
                closedSet.add(neighbour);
                openStack.add(neighbour);
                completeSurface.add(neighbour);
            }
        }
        return completeSurface;
    }

    private List<Coordinate> getNeighbours(final Coordinate currentNode, final Coordinate[][] copiedGrid, final Set<Coordinate> closedSet) {
        final List<Coordinate> neighbours = gridToCompute.getNeighbours(currentNode);
        List<Coordinate> result = new ArrayList<>(4);
        for (Coordinate coordinate : neighbours) {
            final Coordinate potentialNeighbour = copiedGrid[coordinate.getX()][coordinate.getY()];
            if (!closedSet.contains(potentialNeighbour)) {
                result.add(potentialNeighbour);
            }
        }
        return result;
    }

    private Coordinate[][] initialize() {
        final int width = gridToCompute.getWidth();
        final int height = gridToCompute.getHeight();
        final Coordinate[][] copiedGrid = new Coordinate[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                copiedGrid[x][y] = new Coordinate(x, y);
            }
        }
        return copiedGrid;
    }
}
