package ru.academits.Range.LV.Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double value) {
        return (value >= from && value <= to);
    }

    public Range getIntersection(Range second) {
        double maxFrom = Math.max(this.from, second.from);
        double minTo = Math.min(this.to, second.to);

        if (maxFrom < minTo) {
            return new Range(maxFrom, minTo);
        } else {
            return null;
        }
    }

    public Range[] getUnion(Range second) {
        if (this.to < second.from) {
            return new Range[]{new Range(this.from, this.to), new Range(second.from, second.to)};
        } else if (this.from > second.to) {
            return new Range[]{new Range(second.from, second.to), new Range(this.from, this.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, second.from), Math.max(this.to, second.to))};
        }
    }

    public Range[] getDifference(Range second) {
        if (this.from < second.from) {
            if (second.from < this.to) {
                if (second.to >= this.to) {
                    return new Range[]{new Range(this.from, second.from)};
                } else {
                    return new Range[]{new Range(this.from, second.from), new Range(second.to, this.to)};
                }
            } else {
                return new Range[]{new Range(this.from, this.to)};
            }
        } else {
            if (second.to > this.from) {
                if (second.to < this.to) {
                    return new Range[]{new Range(second.to, this.to)};
                }
            } else {
                return new Range[]{new Range(this.from, this.to)};
            }
        }
        return new Range[0];
    }
}