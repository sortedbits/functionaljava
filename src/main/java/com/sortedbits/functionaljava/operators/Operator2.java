package com.sortedbits.functionaljava.operators;

import com.sortedbits.functionaljava.functions.Function2;

public interface Operator2<T> extends Operator, java.util.function.BinaryOperator<T>, Function2<T, T, T> {
}
