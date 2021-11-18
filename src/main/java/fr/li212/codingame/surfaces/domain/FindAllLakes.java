package fr.li212.codingame.surfaces.domain;

import fr.li212.codingame.surfaces.domain.finder.SurfaceFinder;
import fr.li212.codingame.surfaces.domain.finder.SurfaceFinderForBigSurfaces;
import fr.li212.codingame.surfaces.domain.finder.SurfaceFinderForSmallSurfaces;
import fr.li212.codingame.surfaces.domain.io.PrintGameInput;
import fr.li212.codingame.surfaces.domain.models.GameInput;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllLakes {
    final PrintGameInput printGameInput;

    public FindAllLakes(final PrintGameInput printGameInput) {
        this.printGameInput = printGameInput;
    }

    public List<Integer> find(final GameInput input) {
        this.printGameInput.print(input);

        final SurfaceFinder surfaceFinder;
        if (input.getCoordinatesToTest().size() > 50) {
            surfaceFinder = new SurfaceFinderForSmallSurfaces(input.getGrid());
        } else {
            surfaceFinder = new SurfaceFinderForBigSurfaces(input.getGrid());
        }

        final FindOneLake findOneLake = new FindOneLake(surfaceFinder);
        return input.getCoordinatesToTest().stream()
                .map(findOneLake::find)
                .collect(Collectors.toList());
    }
}
