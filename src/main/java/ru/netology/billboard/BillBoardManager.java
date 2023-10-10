package ru.netology.billboard;

import ru.netology.domain.BillBoard;

public class BillBoardManager {
    private BillBoard[] playbill = new BillBoard[0];
    private int limit;

    public int getLimit() {
        return limit;
    }

    public BillBoardManager() {
        limit = 5;
    }

    public BillBoardManager(int limit) {
        this.limit = limit;
    }

    public BillBoard[] findAll() {
        return playbill;
    }


    public void add(BillBoard item) {
        int length = playbill.length + 1;
        BillBoard[] tmp = new BillBoard[length];
        System.arraycopy(playbill, 0, tmp, 0, playbill.length);


        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        playbill = tmp;

    }

    public BillBoard[] findLast() {
        BillBoard[] playbill = findAll();
        BillBoard[] result;
        if (limit < playbill.length) {
            result = new BillBoard[limit];
        } else {
            result = new BillBoard[playbill.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = playbill.length - i - 1;
            result[i] = playbill[index];
        }
        return result;
    }

}
