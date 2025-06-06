package util.values;

public class FractionInterval extends Interval<Fraction> {

    public FractionInterval(Fraction min, Fraction max){
        super(min, max);
    }

    public FractionInterval(FractionInterval interval) {
        this(interval.min(), interval.max());
    }

    public FractionInterval(Fraction max) {
        this(new Fraction(), max);
    }

    public FractionInterval() {
        this(new Fraction());
    }

    public FractionInterval(Interval<Fraction> element) {
        super(element.min(), element.max());
    }

    public Fraction length() {
        return this.max().subtract(this.min());
    }

    public Fraction middlePoint() {
        return this.min().add(this.length().divide(2).get());
    }

    public FractionInterval shifted(Fraction shiftment) {
        return new FractionInterval(this.min().add(shiftment), this.max().add(shiftment));
    }

    public FractionInterval scaled(int scale) {
        Fraction newMiddelPoint = this.middlePoint();
        Fraction newHalfLength = this.length().multiply(scale / 2);
        return new FractionInterval(newMiddelPoint.subtract(newHalfLength), newMiddelPoint.add(newHalfLength));
    }

    public FractionInterval symetric() {
        return new FractionInterval(this.max().opposite(), this.min().opposite());
    }

    public boolean includes(FractionInterval interval) {
        assert this != null;

        return this.includes(interval.min())
                && this.includes(interval.max());
    }

    public boolean includes(Fraction point) {
        assert point != null;

        return this.min().compareTo(point) <= 0
                && point.compareTo(this.max()) <= 0;
    }

    public boolean isIntersected(FractionInterval interval) {
        assert interval != null;

        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }

    public FractionInterval intersection(FractionInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new FractionInterval(interval);
        }
        if (interval.includes(this)) {
            return new FractionInterval(this);
        }
        if (this.includes(interval.min())) {
            return new FractionInterval(interval.min(), this.max());
        }
        return new FractionInterval(this.min(), interval.max());
    }

    public FractionInterval union(FractionInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new FractionInterval(this);
        }
        if (interval.includes(this)) {
            return new FractionInterval(interval);
        }
        if (this.includes(interval.min())) {
            return new FractionInterval(this.min(), interval.max());
        }
        return new FractionInterval(interval.min(), this.max());
    }
    public FractionInterval superInterval(FractionInterval interval) {
        assert interval != null;

        Fraction min = this.min().compareTo(interval.min()) < 0 ? this.min()
                : interval.min();
                Fraction max = this.max().compareTo(interval.max()) > 0 ? this.max()
                : interval.max();
        return new FractionInterval(min, max);
    }

    public FractionInterval[] split(int times) {
        assert times > 0;

        FractionInterval[] intervals = new FractionInterval[times];
        final Fraction length = this.length().divide(times).get();
        intervals[0] = new FractionInterval(this.min(), this.min().add(length));
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }
    
}
