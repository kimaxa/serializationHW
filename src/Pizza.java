public class Pizza {
    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", filling='" + filling + '\'' +
                '}';
    }

    Dough dough = new Dough();
    String filling;
}
