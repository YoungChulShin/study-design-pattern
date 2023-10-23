package study.designpattern.external;

import java.util.List;

public class ExternalQueryClient {

  public QueryResponse search(String keyword) {
    return new QueryResponse(
        List.of(
            new QueryDocumentList(
                List.of(
                    new QueryDocument("1"),
                    new QueryDocument("2"),
                    new QueryDocument("3"),
                    new QueryDocument("4")
                )
            )
        )
    );
  }
}
