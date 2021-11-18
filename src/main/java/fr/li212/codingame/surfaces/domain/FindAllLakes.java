package fr.li212.codingame.surfaces.domain;

import fr.li212.codingame.surfaces.domain.finder.SurfaceFinder;
import fr.li212.codingame.surfaces.domain.models.GameInput;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllLakes {
    public List<Integer> find(final GameInput input) {
        final SurfaceFinder surfaceFinder = new SurfaceFinder(input.getGrid());
        return input.getCoordinatesToTest().stream()
                .map(coordinate -> surfaceFinder.findSurface(coordinate).size())
                .collect(Collectors.toList());
    }
}
