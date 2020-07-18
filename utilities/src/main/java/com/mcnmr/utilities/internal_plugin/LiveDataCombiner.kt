package com.mcnmr.utilities.internal_plugin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun <A, B> combineLiveData(one: LiveData<A>, block: (A?) -> B): LiveData<B> {
    val result = MediatorLiveData<B>()
    result.addSource(one) { result.value = block.invoke(one.value) }
    return result
}

fun <A, B, C> combineLiveData(one: LiveData<A>, two: LiveData<B>, block: (A?, B?) -> C): LiveData<C> {
    val result = MediatorLiveData<C>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value) }
    return result
}

fun <A, B, C, D> combineLiveData(one: LiveData<A>, two: LiveData<B>, three: LiveData<C>,
                                 block: (A?, B?, C?) -> D): LiveData<D> {
    val result = MediatorLiveData<D>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value, three.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value, three.value) }
    result.addSource(three) { result.value = block.invoke(one.value, two.value, three.value) }
    return result
}

fun <A, B, C, D, E> combineLiveData(one: LiveData<A>, two: LiveData<B>, three: LiveData<C>,
                                    four: LiveData<D>, block: (A?, B?, C?, D?) -> E): LiveData<E> {
    val result = MediatorLiveData<E>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value, three.value, four.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value, three.value, four.value) }
    result.addSource(three) { result.value = block.invoke(one.value, two.value, three.value, four.value) }
    result.addSource(four) { result.value = block.invoke(one.value, two.value, three.value, four.value) }
    return result
}

fun <A, B, C, D, E, F> combineLiveData(one: LiveData<A>, two: LiveData<B>, three: LiveData<C>,
                                       four: LiveData<D>, five: LiveData<E>,
                                       block: (A?, B?, C?, D?, E?) -> F): LiveData<F> {
    val result = MediatorLiveData<F>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value) }
    result.addSource(three) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value) }
    result.addSource(four) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value) }
    result.addSource(five) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value) }
    return result
}

fun <A, B, C, D, E, F, G> combineLiveData(one: LiveData<A>, two: LiveData<B>, three: LiveData<C>,
                                       four: LiveData<D>, five: LiveData<E>, six: LiveData<F>,
                                       block: (A?, B?, C?, D?, E?, F?) -> G): LiveData<G> {
    val result = MediatorLiveData<G>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    result.addSource(three) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    result.addSource(four) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    result.addSource(five) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    result.addSource(six) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value) }
    return result
}

fun <A, B, C, D, E, F, G, H> combineLiveData(one: LiveData<A>, two: LiveData<B>, three: LiveData<C>,
                                             four: LiveData<D>, five: LiveData<E>, six: LiveData<F>,
                                             seven: LiveData<G>, block: (A?, B?, C?, D?, E?, F?, G?) -> H): LiveData<H> {
    val result = MediatorLiveData<H>()
    result.addSource(one) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(two) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(three) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(four) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(five) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(six) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    result.addSource(seven) { result.value = block.invoke(one.value, two.value, three.value, four.value, five.value, six.value, seven.value) }
    return result
}