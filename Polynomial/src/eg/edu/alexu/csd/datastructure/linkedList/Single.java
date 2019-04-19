package eg.edu.alexu.csd.datastructure.linkedList;

public class Single implements ILinkedList {
	Node head;

	public void add(int index, Object element) {
		if (index > size()) {
			return;
		}
		if (index == 0) {
			if (head == null) {
				head = new Node(element);
				return;
			}
			Node headnew = new Node(element);
			headnew.next = head;
			head = headnew;
			return;
		}
		int i = 1;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		Node New = new Node(element);
		New.next = current.next;
		current.next = New;
		return;

	}

	@Override
	public void show() {
		if(head==null)
			return;
		Node current = head;
		while (current != null) {
			System.out.print(current.data+" ");
			System.out.println();
			current = current.next;
		}
	}

	@Override
	public void add(Object element) {
		if (head == null) {
			add(0, element);
			return;
		}
		add(size(),element);
	}

	@Override
	public Object get(int index) {
		if (head == null || index > this.size() - 1) {
			return null;
		}
		int i = 0;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		return current.data;
	}

	@Override
	public void set(int index, Object element) {
		if (index > size() - 1) {
			return;
		}
		Node current = head;
		if (index == 0) {
			head.data = element;
			return;
		}
		int i = 0;
		while (i < index) {
			current = current.next;
			i++;
		}
		current.data = element;

	}

	@Override
	public void clear() {
		head = null;

	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		if (index == 0) {
			head = head.next;
			return;
		}
		if (index > size() - 1) {
			return;
		}
		int i = 1;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		current.next = current.next.next;
	}

	@Override
	public int size() {
		Node current = head;
		int i = 0;
		while (current != null) {
			i++;
			current = current.next;
		}
		return i;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		ILinkedList l=new Single();
		if(fromIndex>=0&&fromIndex<size()&& toIndex>=0 && toIndex<size())
		{
			
			int i=0;
			Node current=head;
			while(i<=toIndex)
			{
				if(i>=fromIndex)
				{
					l.add(current.data);
				}
				current=current.next;
				i++;
			}
			return l;
		}
		return null;

	}

	@Override
	public boolean contains(Object o) {
		Node current=head;
		while(current!=null)
		{
			if(current.data==o)
			{
				return true;
			}
			current=current.next;
		}
		return false;
	}

}
