package dev.challenge.util;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class ListSize<T> extends ArrayList<T> {

  private final int size;

  @Override
  public int size() {
    return size;
  }
}
