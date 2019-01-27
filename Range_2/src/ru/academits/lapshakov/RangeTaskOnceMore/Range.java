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
        if ((secondInterval.from >= this.from && secondInterval.from < this.to) || (secondInterval.from <= this.from && secondInterval.from > this.to)) {
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
        //if intervals have intersections:
        if ((secondInterval.from >= this.from && secondInterval.from < this.to)) {
            return new Range[]{new Range(this.from, secondInterval.from), new Range(this.to, secondInterval.to)};
        } else if (secondInterval.from <= this.from && secondInterval.from > this.to) {
            return new Range[]{new Range(secondInterval.from, this.from), new Range(secondInterval.to, this.to)};
        }//if intervals don't have intersections:
        else if ((this.to < secondInterval.from)) {
            return new Range[]{new Range(this.to, this.from)};
        } else if (this.from > secondInterval.to) {
            return new Range[]{new Range(secondInterval.from, secondInterval.to)};
        }//if intervals belongs each other:
        else if (this.from >= secondInterval.from && this.to >= secondInterval.to) {
            return new Range[]{new Range(secondInterval.from, this.from), new Range(secondInterval.to, this.to)};
        } else if (secondInterval.from >= this.from && secondInterval.to >= this.to) {
            return new Range[]{new Range(this.from, secondInterval.from), new Range(this.to, secondInterval.to)};
        } else {
            return null;
        }
    }
}
