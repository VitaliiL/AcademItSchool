package ru.academits.lapshakov.RangeTaskOnceMore;

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

    public double getIntervalLength() {
        return to - from;
    }

    public boolean isInsideInterval(double value) {
        return (value >= from && value <= to);
    }

    public Range getIntersectionRangeResult(Range secondInterval) {
        if ((secondInterval.to >= this.from && secondInterval.to <= this.to) || (this.to >= secondInterval.from && this.to <= secondInterval.to)) {
            return new Range(Math.max(this.from, secondInterval.from), Math.min(this.to, secondInterval.to));
        } else {
            return null;
        }
    }

    public Range[] getUnionRangeResult(Range secondInterval) {
        if (this.to < secondInterval.from) {
            return new Range[]{new Range(this.from, this.to), new Range(secondInterval.from, secondInterval.to)};
        } else if (this.from > secondInterval.to) {
            return new Range[]{new Range(secondInterval.from, secondInterval.to), new Range(this.from, this.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, secondInterval.from), Math.max(this.to, secondInterval.to))};
        }
    }

    public Range[] getDifferenceRangeResult(Range secondInterval) {
        if (this.from < secondInterval.from) {
            if (secondInterval.from < this.to) {
                if (secondInterval.to > this.to) {
                    return new Range[]{new Range(this.from, secondInterval.from)};
                } else {
                    return new Range[]{new Range(this.from, secondInterval.from), new Range(secondInterval.to, this.to)};
                }
            } else {
                return new Range[]{new Range(this.from, this.to)};
            }

        } else if (this.from >= secondInterval.from) {
            if (secondInterval.to > this.from) {
                if (secondInterval.to < this.to) {
                    return new Range[]{new Range(secondInterval.to, this.to)};
                } else {
                    return new Range[0];
                }
            } else {
                return new Range[]{new Range(this.from, this.to)};
            }
        }
        return new Range[0];
    }
}