package fr.li212.codingame.surfaces.domain.finder;

import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;

class Node {
    private static int CURRENT_CLOSED_IDENTIFIER = 1;
    private final Coordinate underlyingCoordinates;
    private int closedIdentifier = 0;

    public Node(final Coordinate underlyingCoordinates) {
        this.underlyingCoordinates = underlyingCoordinates;
    }

    public boolean isClosed() {
        return this.closedIdentifier == CURRENT_CLOSED_IDENTIFIER;
    }

    public void setClosed() {
        this.closedIdentifier = CURRENT_CLOSED_IDENTIFIER;
    }

    public static void updateClosedIdentifier() {
        CURRENT_CLOSED_IDENTIFIER++;
    }

    public Coordinate getUnderlyingCoordinates() {
        return underlyingCoordinates;
    }
}
