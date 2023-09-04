package study.designpattern.search;

import java.util.List;

public class DbSearchService implements SearchService {

  @Override
  public SearchResult search(String keyword) {
    return new SearchResult(
        List.of(
            new SearchDocument("1"),
            new SearchDocument("2"),
            new SearchDocument("3")
        )
    );
  }
}
