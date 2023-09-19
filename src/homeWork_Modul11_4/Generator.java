package homeWork_Modul11_4;

import java.util.stream.Stream;

public class Generator implements Peremenie{
    private long a;
    private long c;
    private long m;
    private long seed;

    public Generator(long a, long c, long m, long seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }
    @Override
    public Stream<Long> generate(long a, long c, long m, long seed) {
        final long[] x = {seed};

        return Stream.iterate(seed, n -> {
            x[0] = (a * x[0] + c) % m;
            return x[0];
        });
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0;

        Generator generator = new Generator(a, c, m, seed);
        Stream<Long> randomStream = generator.generate(generator.a, generator.c, generator.m, generator.seed);
                randomStream.limit(20).forEach(x -> System.out.println(x));
    }

}
