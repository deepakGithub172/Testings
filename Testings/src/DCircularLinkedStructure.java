public class DCircularLinkedStructure {

	private  int threshold = 4;
	private  Element first;
	private  int elementCount;

	public int getThreshold() {
		return threshold;
	}

	public int getElementCount() {
		return elementCount;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public static void main(String[] args) {
		DCircularLinkedStructure dCircularLinkedList = new DCircularLinkedStructure();
		dCircularLinkedList.addElement(1);
		dCircularLinkedList.addElement(2);
		dCircularLinkedList.addElement(3);
		dCircularLinkedList.addElement(4);

		dCircularLinkedList.removeElement(3);
		//dCircularLinkedList.addElement(1);

	}

	public  void addElement(int value) {

		if(threshold == elementCount)
			throw new IllegalArgumentException("Reached threshold limit.");

		Element newElement = new Element(value, null, null);
		if(first == null) {
			first = newElement;
			first.setPrevElement(newElement);
			first.setNextElement(newElement);
		} else {
			Element last = first.getPrevElement();
			newElement.setNextElement(first);
			newElement.setPrevElement(last);
			first.setPrevElement(newElement);
			last.setNextElement(newElement);
		}
		elementCount++;
	}

	/*	public void removeElement(int value) {
	if(elementCount == 0)
		throw new IllegalArgumentException("No such element found.");

	Element currentElement = first;
	boolean elementFound = false;
	do {
		if(currentElement.getValue() == value) {
			elementFound = true;
			Element prevElement = currentElement.getPrevElement();
			Element nextElement = currentElement.getNextElement();
			prevElement.setNextElement(nextElement);
			nextElement.setPrevElement(prevElement);
			currentElement.setNextElement(null);
			currentElement.setPrevElement(null);
			elementCount--;
			break;
		}
		currentElement = currentElement.getNextElement();
	} while(currentElement != first);

	if(!elementFound)
		throw new IllegalArgumentException("No such element found.");

}*/
	
	public void removeElement(int value) {
		if(elementCount == 0)
			throw new IllegalArgumentException("No such element found.");

		if(first.getValue() == value) {
			remove(first);
			first = first.getNextElement();		
			if(elementCount == 0)
				first = null;
			return;
		}
		
		Element currentElement1 = first.getPrevElement();
		Element currentElement2 = first.getNextElement();
		boolean elementFound = false;
		for(int i=1;i<=elementCount/2;i++) {
			if(currentElement1.getValue() == value) {
				elementFound = true;
				remove(currentElement1);
				break;
			}
			currentElement1= currentElement1.getPrevElement();
			if(currentElement2.getValue() == value) {
				elementFound = true;
				remove(currentElement2);
				break;
			}
			currentElement2 = currentElement2.getNextElement();
		}

		if(!elementFound)
			throw new IllegalArgumentException("No such element found.");

	}
	

	private void remove(Element current) {
		Element prevElement = current.getPrevElement();
		Element nextElement = current.getNextElement();
		prevElement.setNextElement(nextElement);
		nextElement.setPrevElement(prevElement);
		elementCount--;
	}

	private static class Element {

		private int value;
		private Element prevElement;
		private Element nextElement;

		public Element(int value, Element prevElement, Element nextElement) {
			this.value = value;
			this.prevElement = prevElement;
			this.nextElement = nextElement;
		}

		public int getValue() {
			return value;
		}

		public Element getPrevElement() {
			return prevElement;
		}

		public void setPrevElement(Element prevElement) {
			this.prevElement = prevElement;
		}

		public Element getNextElement() {
			return nextElement;
		}

		public void setNextElement(Element nextElement) {
			this.nextElement = nextElement;
		}

	}

}
