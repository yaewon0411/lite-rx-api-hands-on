package io.pivotal.literx;

import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

	// TODO Return an empty Mono
	Mono<String> emptyMono() {
		return Mono.empty();
	}

	void emptyMonoTest(){
		emptyMono()
				.subscribe(
						value -> System.out.println("받은 값 = " + value),
						error -> System.out.println("에러 =  " + error.getMessage()),
						() -> System.out.println("완료 신호 방출")
				);
	}

//========================================================================================

	// TODO Return a Mono that never emits any signal
	Mono<String> monoWithNoSignal() {
		return Mono.never();
	}

	void monoWithNoSignalTest(){
		monoWithNoSignal()
				.subscribe(
						value -> System.out.println("받은 값 = " + value),
						error -> System.out.println("에러 =  " + error.getMessage()),
						() -> System.out.println("완료 신호 방출")
				);
	}

//========================================================================================

	// TODO Return a Mono that contains a "foo" value
	static Mono<String> fooMono() {
		return Mono.just("foo");
	}

	static void fooMonoTest(){
		fooMono()
				.subscribe(
						value -> System.out.println("받은 값 = " + value),
						error -> System.out.println("에러 =  " + error.getMessage()),
						() -> System.out.println("완료 신호 방출")
				);
	}

	public static void main(String[] args) {
		fooMonoTest();
	}

//========================================================================================

	// TODO Create a Mono that emits an IllegalStateException
	Mono<String> errorMono() {
		return Mono.error(new IllegalAccessException("error"));
	}

	void errorMonoTest(){
		errorMono()
				.subscribe(
						value -> System.out.println("받은 값 = " + value),
						error -> System.out.println("에러 =  " + error.getMessage()),
						() -> System.out.println("완료 신호 방출")
				);
	}

}
