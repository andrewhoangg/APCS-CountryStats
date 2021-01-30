public class Main {

    public static void printStats(String[] countries, int[] population, int[] area, double[] gdp) {
        for (int i = 0; i < countries.length; i++) {
            System.out.println(countries[i]);
            System.out.println("Population:" + population[i]);
            System.out.println("Area square Kilometers:" + area[i]);
            System.out.println("GDP in Billions of USD:" + gdp[i] + "\n");
        }
    }

    public static String countryWithLargestPopulation(String[] countries, int[] population) {
        int index = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[index] < population[i])
                index = i;
        }
        return countries[index];
    }

    public static String countryWithSmallestArea(String[] countries, int[] area) {
        int index = 0;
        for (int i = 0; i < area.length; i++) {
            if (area[index] > area[i])
                index = i;
        }
        return countries[index];
    }

    public static String countryWithHighestPopulationDensity(String[] countries, int[] population, int[] area) {
        /*
            1. Population Density of a country is population / area
            2. loop through the countries, grab the index of the population & area
            3. divide the population & area at the same index
            4. store in a number array and find the largest value in that array
            5. grab the index of the number and use it to return the country
        */

        int[] list = new int[countries.length];

        int index=0;
        for (int i=0; i<countries.length; i++) {
            list[i] = population[i]/area[i];

            for (int j = 0; j < list.length; j++) {
                if (list[index] < list[i])
                    index = j;
            }
        }
        return countries[index];
    }

    public static String countryWithLowestPopulationDensity(String[] countries, int[] population, int[] area) {
        int[] list = new int[countries.length];

        int index=0;
        for (int i=0; i<countries.length; i++) {
            list[i] = population[i]/area[i];
            
            for (int j = 0; j < list.length; j++) {
                if (list[index] > list[i])
                    index = j;
            }
        }
        return countries[index];
    }

    public static String countryWithHighestGDP(String[] countries, double[] gdp) {
        int index = 0;
        for (int i = 0; i < gdp.length; i++) {
            if (gdp[index] < gdp[i])
                index = i;
        }
        return countries[index];
    }

    public static String countryWithLowestPerCapitaGDP(String[] countries, double[] gdp, int[] population) {

        double[] list = new double[countries.length];

        int index=0;
        for (int i=0; i<countries.length; i++) {
            list[i] = gdp[i]/population[i];
            
            for (int j = 0; j < list.length; j++) {
                if (list[index] > list[i])
                    index = j;
            }
        }
        return countries[index];

    }

    public static String countryWithLowestGDPtoArea(String[] countries, double[] gdp, int[] area) {

        double[] list = new double[countries.length];

        int index=0;
        for (int i=0; i<countries.length; i++) {
            list[i] = gdp[i]/area[i];
            
            for (int j = 0; j < list.length; j++) {
                if (list[index] > list[i])
                    index = j;
            }
        }
        return countries[index];

    }

    public static String countryWithHighestGDPtoArea(String[] countries, double[] gdp, int[] area) {

        double[] list = new double[countries.length];

        int index=0;
        for (int i=0; i<countries.length; i++) {
            list[i] = gdp[i]/area[i];
            
            for (int j = 0; j < list.length; j++) {
                if (list[index] < list[i])
                    index = j;
            }
        }
        return countries[index];

    }

    public static void main(String[] args) {

        String[] countries = { "China\t", "India\t", "United States", "Indonesia", "Brazil\t", "Pakistan", "Nigeria",
                "Bangladesh", "Russia\t", "Mexico\t" };

        int[] population = { 1388232693, 1342512706, 326474013, 263510146, 211243220, 196744376, 191835946, 164827718,
                143375006, 130222815 };

        int[] areaInSquareKM = { 9388211, 2973190, 9147420, 1811570, 8358140, 770880, 910770, 130170, 16376870,
                1943950 };

        double[] gdpInBillionsOfUSD = { 11795.297, 2454.458, 19417.144, 1020.515, 2140.940, 251.487, 400.621, 248.853,
                1560.706, 987.303 };

        printStats(countries, population, areaInSquareKM, gdpInBillionsOfUSD);

        System.out.println(countryWithLargestPopulation(countries, population) + "\t has the greatest population");

        System.out
                .println(countryWithSmallestArea(countries, areaInSquareKM) + "\t has the smallest size in square KM");

        System.out.println(countryWithLowestPopulationDensity(countries, population, areaInSquareKM)
                + "\t has the least people per square KM");

        System.out.println(countryWithHighestPopulationDensity(countries, population, areaInSquareKM)
                + "\t has the most people per square KM");

        System.out.println(countryWithHighestGDP(countries, gdpInBillionsOfUSD) + "\t is the richest overall");

        System.out.println(countryWithLowestPerCapitaGDP(countries, gdpInBillionsOfUSD, population)
                + "\t is the poorest per person");

        System.out.println(countryWithHighestGDPtoArea(countries, gdpInBillionsOfUSD, areaInSquareKM)
                + "\t has the most money per square KM");

        System.out.println(countryWithLowestGDPtoArea(countries, gdpInBillionsOfUSD, areaInSquareKM)
                + "\t has the least money per square KM");
    }

}