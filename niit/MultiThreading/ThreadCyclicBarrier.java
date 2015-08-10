package com.niit.MultiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * * Java Program to demonstrate how to use CyclicBarrier, Its used when number
 * of threads  needs to wait for each other before starting again. 
 */
public class ThreadCyclicBarrier {
	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1");
		Party second = new Party(2000, barrier, "PARTY-2");
		Party third = new Party(3000, barrier, "PARTY-3");
		Party fourth = new Party(4000, barrier, "PARTY-4");
		first.start();
		second.start();
		third.start();
		fourth.start();
		
		first.join();
		second.join();
		third.join();
		fourth.join();
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has started running again");
			//Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " is calling await()again");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has started running again & again");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
