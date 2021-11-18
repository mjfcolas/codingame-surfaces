package fr.li212.codingame.surfaces.domain.finder;

import fr.li212.codingame.surfaces.domain.models.grid.Cell;
import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;
import fr.li212.codingame.surfaces.domain.models.grid.Grid;

import java.util.*;

public class SurfaceFinderForBigSurfaces implements SurfaceFinder{

    private final Grid gridToCompute;
    private final Node[][] copiedGrid;

    public SurfaceFinderForBigSurfaces(final Grid gridToCompute) {
        this.gridToCompute = gridToCompute;
        this.copiedGrid = initialize();
    }

    @Override
    public final Set<Coordinate> findSurface(final Coordinate germ) {
        final Set<Coordinate> completeSurface = new HashSet<>();
        if (!gridToCompute.getCell(germ).isWater()) {
            return Collections.emptySet();
        }else{
            completeSurface.add(germ);
        }
        this.reset();
        Node startNode = copiedGrid[germ.getX()][germ.getY()];
        startNode.setClosed();
        final Stack<Node> openStack = new Stack<>();
        openStack.add(startNode);
        while (!openStack.isEmpty()) {
            final Node currentNode = openStack.pop();
            final Collection<Node> notClosedNeighbours = this.getNeighbours(currentNode, copiedGrid);
            for (Node neighbour : notClosedNeighbours) {
                neighbour.setClosed();
                openStack.add(neighbour);
                completeSurface.add(neighbour.getUnderlyingCoordinates());
            }
        }
        return completeSurface;
    }

    private List<Node> getNeighbours(final Node currentNode, final Node[][] copiedGrid) {
        final List<Coordinate> neighbours = gridToCompute.getNeighbours(currentNode.getUnderlyingCoordinates());
        List<Node> result = new ArrayList<>(4);
        for (Coordinate coordinate : neighbours) {
            final Node potentialNeighbour = copiedGrid[coordinate.getX()][coordinate.getY()];
            if (!potentialNeighbour.isClosed()) {
                result.add(potentialNeighbour);
            }
        }
        return result;
    }

    private void reset(){
        for (int y = 0; y < copiedGrid[0].length; y++) {
            for (int x = 0; x < copiedGrid.length; x++) {
                copiedGrid[x][y].reset();
            }
        }
    }

    private Node[][] initialize() {
        final Cell[][] grid = gridToCompute.getCells();
        final int width = gridToCompute.getWidth();
        final int height = gridToCompute.getHeight();
        final Node[][] copiedGrid = new Node[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                copiedGrid[x][y] = new Node(grid[x][y].getCoordinate());
            }
        }
        return copiedGrid;
    }
}
