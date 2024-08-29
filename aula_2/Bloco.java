
public class Bloco {

	public Integer valor;
	public Bloco next;

	public Bloco() {}

	public Bloco(int value) {
		this.valor = value;
	}

	public static void main(String[] args) {
		Bloco list = new Bloco(99);
		System.out.println("Numero de elementos = " + list.Length());

		list.PrintBloco();

		for (int i = 0; i < 18; i++) {
			list.Append(i);
		}

		list.PrintBloco();

		list.Insert(56);
		list.Pop();

		list.PrintBloco();

		list.Inject(4, 69);

		list.PrintBloco();

		list.Delete(list.Length() -1);


		list.PrintBloco();

		System.out.println("Numero de elementos = " + list.Length());
	}

	public void Delete(Integer target) {
		Bloco prev;
		Bloco next;

		if (target > 0) {
			if (this.Acess(target).next == null) {
				this.Acess(target - 1).next = null;
			} else {
				prev = this.Acess(target - 1);
				next = this.Acess(target + 1);

				prev.next = next;
			}
		} else {
			if (this.next != null)
			{
				next = Acess(target +1);
				this.valor = next.valor;
				this.next = next.next;
			} else
			{
				this.valor = null;
				this.next = null;
			}
		}
	}

	public void PrintBloco() {
		System.out.printf("Array = { ");

		for (int i = 0; i < this.Length(); i++) {
			System.out.printf("%d ", this.Acess(i).valor);
		}

		System.out.printf("}\n");
	}

	public Bloco Acess(int index) {
		Bloco item = this;
		for (int i = 0; i < index; i++) {
			if (item.next == null) {
				return item;
			} else {
				item = item.next;
			}
		}
		return item;
	}

	public void Pop() {
		Bloco aux = new Bloco();

		aux = this;

		while (aux.next != null) {
			aux = aux.next;

			if (aux.next.next == null) {
				aux.next = null;
				break;
			}
		}

		return;
	}

	public void Insert(int value) {
		Bloco aux = new Bloco(value);
		Bloco old = new Bloco(this.valor);

		aux.next = old;
		old.next = this.next;

		this.valor = aux.valor;
		this.next = aux.next;
	}

	public void Inject(int target, int value) {
		Bloco prox = this.Acess(target);
		Bloco prev = this.Acess(target - 1);

		Bloco newer = new Bloco(value);

		prev.next = newer;
		newer.next = prox;
	}

	public void Append(int value) {
		Integer i = 0;
		Bloco aux = new Bloco();
		aux.valor = value;

		Bloco item = this;

		if (item.valor == null) {
			item.valor = value;
			return;
		}

		while (item.next != null) {
			item = item.next;
			i++;

			if (item.next == null) {
				item.next = aux;
				break;
			}
		}

		if (i == 0) {
			item.next = aux;
		}
	}

	public int Length() {
		Integer len = 1;
		Bloco pointer = this;
		while (pointer.next != null) {
			pointer = pointer.next;
			len++;
		}

		return len;
	}
}
