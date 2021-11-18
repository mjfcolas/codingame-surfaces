package fr.li212.codingame.surfaces.application;

import fr.li212.codingame.surfaces.domain.FindAllLakes;
import fr.li212.codingame.surfaces.domain.models.GameInput;
import fr.li212.codingame.surfaces.domain.models.grid.Cell;
import fr.li212.codingame.surfaces.domain.models.grid.CellType;
import fr.li212.codingame.surfaces.domain.models.grid.Coordinate;
import fr.li212.codingame.surfaces.domain.models.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static final FindAllLakes FIND_ALL_LAKES = new FindAllLakes();

    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        final Cell[][] grid = new Cell[L][H];

        for (int y = 0; y < H; y++) {
            final String rowString = in.nextLine();
            char[] row = rowString.toCharArray();
            for (int x = 0; x < L; x++) {
                grid[x][y] = new Cell(new Coordinate(x, y), row[x] == '#' ? CellType.LAND : CellType.WATER);
            }
        }
        final List<Coordinate> coordinatesToFind = new ArrayList<>();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            coordinatesToFind.add(new Coordinate(in.nextInt(), in.nextInt()));
        }

        final GameInput input = new GameInput(new Grid(grid), coordinatesToFind);
        final List<Integer> result = FIND_ALL_LAKES.find(input);
        result.forEach(System.out::println);
    }
}
