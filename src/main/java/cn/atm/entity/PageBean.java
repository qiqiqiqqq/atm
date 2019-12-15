package cn.atm.entity;

import java.util.List;

public class PageBean<T> {
	private int currenPage;//当前页码page code
	private int totalPage;//总页数total page
	private int totalCount;//总页码
	private List<T> list;//当前页记录
	private int rows;//每页显示的记录数

	public int getCurrenPage() {
		return currenPage;
	}

	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"currenPage=" + currenPage +
				", totalPage=" + totalPage +
				", totalCount=" + totalCount +
				", list=" + list +
				", rows=" + rows +
				'}';
	}
}
