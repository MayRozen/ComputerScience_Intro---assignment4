package Exe.Ex4;

public class IntCell {
	private int _value; //The information field.
	public IntCell _next; //The administration field.
	
	public IntCell(int val, IntCell next)
	{
	_value = val;
	_next = next;
	}
	
	public void setValue(int val){ _value = val; }
	
	public void setNext(IntCell next){ _next = next; }
	
	public int getValue() { return _value; }
	
	public IntCell getNext() { return _next; }
	
}
