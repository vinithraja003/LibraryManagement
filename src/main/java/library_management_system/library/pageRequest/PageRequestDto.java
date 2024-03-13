package library_management_system.library.pageRequest;

import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class PageRequestDto {
	 private Integer pageNo;
	 private Integer pageSize;
	 private String search_name;
	 private Integer count;
	 
//sort direction is ascending:
	 private Sort.Direction sort=Sort.Direction.ASC;
	 
	 private String sortByColumn;
	 
	//getter and setter
	 
		public Integer getPageNo() {
			return pageNo;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public String getSearch_name() {
			return search_name;
		}

		public void setSearch_name(String search_name) {
			this.search_name = search_name;
		}

		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public Sort.Direction getSort() {
			return sort;
		}

		public void setSort(Sort.Direction sort) {
			this.sort = sort;
		}

		public String getSortByColumn() {
			return sortByColumn;
		}

		public void setSortByColumn(String sortByColumn) {
			this.sortByColumn = sortByColumn;
		}

	
	
	public  Pageable getPageable(PageRequestDto dto) {
		 
		 Integer page = Objects.nonNull(dto.getPageNo()) ? dto.getPageNo() : this.pageNo;
	     Integer size = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : this.pageSize;
	      Sort.Direction sort = Objects.nonNull(dto.getSort()) ? dto.getSort() : this.sort;
	        String sortByColumn = Objects.nonNull(dto.getSortByColumn()) ? dto.getSortByColumn() : this.sortByColumn;
	        		
	        // PageRequest request = PageRequest.of(page, size);
	        PageRequest request = PageRequest.of(page, size, sort, sortByColumn);
	        return request;
	
	}

	


	
}
