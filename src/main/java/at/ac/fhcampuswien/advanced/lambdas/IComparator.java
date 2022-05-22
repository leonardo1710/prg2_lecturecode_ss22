package at.ac.fhcampuswien.advanced.lambdas;

    @FunctionalInterface
    public interface IComparator<T> {
        int compare(T object1, T object2);
    }


