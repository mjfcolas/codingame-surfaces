package fr.li212.codingame.surfaces.domain.finder;

import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;

public class Node {
    private final Coordinate underlyingCoordinates;
    private boolean isClosed = false;

    public Node(final Coordinate underlyingCoordinates) {
        this.underlyingCoordinates = underlyingCoordinates;
    }

    public void reset(){
        this.isClosed = false;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

    public Coordinate getUnderlyingCoordinates() {
        return underlyingCoordinates;
    }
}
