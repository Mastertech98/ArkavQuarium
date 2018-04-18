#include <iostream>
#include "../LinkedList.hpp"
using namespace std;

int main(){
	LinkedList<int> listInt;

	listInt.add(5);
	listInt.add(4);
	listInt.add(3);
	listInt.add(2);
	listInt.add(1);
	listInt.add(0);

	cout << "List berisi angka 0 sampai dengan 5 " << endl;
	cout<< "TEST find() dengan angka yang ada dan tidak ada"<< endl;
	cout<<"Angka 5"<<endl;
	if(listInt.find(5) != -1){
		cout << "SUCCESS !!"<<endl;
	} else {
		cout << "FAILED !!" << " Expected found" << endl;
	}
	cout << "Angka 6"<< endl;
	if(listInt.find(6) == -1){
		cout << "SUCCESS !!"<<endl;
	} else {
		cout << "FAILED !!" << " Expected not found" << endl;
	}

	cout << "TEST getFirst()"<<endl;
	ElementList<int> *A = listInt.getFirst();
	if(A->data == 5){
		cout << "SUCCESS !!"<<endl;
	} else {
		cout << "FAILED !!" << " Expected 5"<<endl;
	}

	cout <<"TEST get()"<<endl;
	if(listInt.get(4) == 1){
		cout << "SUCCESS !!"<<endl;
	} else {
		cout <<"FAILED !!" << " Expected 1"<<endl;
	}

	listInt.remove(5);
	listInt.remove(4);
	listInt.remove(3);
	listInt.remove(2);
	listInt.remove(1);
	listInt.remove(0);

	cout <<"TEST remove() dan isEmpty()"<<endl;
	if(listInt.isEmpty()){
		cout<<"SUCCESS !!"<<endl;
	} else {
		cout << "FAILED !!"<<endl;
	}

}

