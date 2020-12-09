package org.example;

import java.util.Spliterator;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

public class UniqCountSpliterator implements Spliterator.OfLong {
	private final Spliterator wrapped;
	private long count;
	private Object previous;
	private Object current;
	
	public UniqCountSpliterator(Spliterator wrapped) {
		this.wrapped = wrapped;
	}
	
	public LongStream stream() {
		return StreamSupport.longStream(this, false);
	}
	
	@Override
	public OfLong trySplit() {
		return null;
	}
	
	@Override
	public long estimateSize() {
		return Long.MAX_VALUE;
	}
	
	@Override
	public int characteristics() {
		return NONNULL | IMMUTABLE;
	}
	
	@Override
	public boolean tryAdvance(LongConsumer action) {
		while (wrapped.tryAdvance(next -> current = next) && (null == previous || current.equals(1))) {
			if (current.equals(1)) count++;
			previous = current;
		}
		if (previous == null) {
			return false;
		}
		action.accept(count);
		if (current.equals(1)) count = 1;
		if (current.equals(0)) count = 0;
		previous = null;
		return true;
	}
}
