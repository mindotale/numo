package dev.challenge.mapper;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import dev.challenge.entity.User.Fields;
import dev.challenge.model.search.OrderClause;
import dev.challenge.model.search.SearchRequest;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

@Component
public class SearchPageRequestMapper {

  private static final List<OrderClause> DEFAULT_ORDER =
      List.of(OrderClause.of(Direction.ASC, Fields.name));

  public PageRequest toPageRequest(SearchRequest request) {
    var orderClauses = isEmpty(request.getOrder()) ? DEFAULT_ORDER : request.getOrder();
    var orderBy =
        orderClauses.stream()
            .map(orderClause -> new Order(orderClause.getDirection(), orderClause.getProperty()))
            .collect(toList());
    return PageRequest.of(request.getPage(), request.getPageSize(), Sort.by(orderBy));
  }
}
