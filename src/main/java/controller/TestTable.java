package controller;

import bll.BLLException;
import bll.TableBLL;

public class TestTable {
public static void main(String[] args) throws BLLException {
	TableBLL tableBll = new TableBLL();
	tableBll.insert(1,1,1);
}
	
}
