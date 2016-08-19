package com.revature.di;

public class Coupling {
	public static void main(String[] args) {
		
	}

}
class A{ // A is no longer 'dependent on' C
		void bar(){
			I i = BeanManager.getBean(); //no reference to C
			i.foo();
		}
}

class BeanManager{
	public static I getBean(){
		return new C();
	}
}

class B implements I{
	public void foo(){}
}
	
class C implements I{
	public void foo(){}
}

interface I{
	void foo();
}
