package task_34;


import java.util.Objects;

/**
 * Розширений клас з інформацією, що є властивою смартфонам.
 * */
public class SmartPhone extends MobilePhone {

    /**
     * Максимальна частота роботи процесора (ГГц)
     * */
    private final double cpuClock;

    /**
     * Кількість фізичних ядер процесора
     * */
    private final byte cpuCores;

    /**
     * Обсяг оперативної пам'яті (гігабайти)
     */
    private final double memory;

    public SmartPhone(String title, int weight, double diagonal, boolean hasCamera, double cpuClock, byte cpuCores, double memory) {
        super(title, weight, diagonal, hasCamera);

        this.cpuClock = cpuClock;
        this.cpuCores = cpuCores;
        this.memory = memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return Double.compare(cpuClock, that.cpuClock) == 0 && cpuCores == that.cpuCores && Double.compare(memory, that.memory) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpuClock, cpuCores, memory);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "cpuClock=" + cpuClock +
                ", cpuCores=" + cpuCores +
                ", memory=" + memory +
                ", title='" + title  +
                "', weight=" + weight +
                ", diagonal=" + diagonal +
                ", hasCamera=" + hasCamera +
                '}';
    }

    public double getCpuClock() {
        return cpuClock;
    }

    public byte getCpuCores() {
        return cpuCores;
    }

    public double getMemory() {
        return memory;
    }
}

