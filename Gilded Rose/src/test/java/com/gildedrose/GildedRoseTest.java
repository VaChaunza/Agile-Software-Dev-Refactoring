package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  private Item createAndUpdate(int sellin, int quality) {
    Item[] items = new Item[] {new Item("foo", sellin, quality)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    return items[0];
  }

  @Test
  void junitFrameworkWorks() {
    Item item = createAndUpdate(0, 0);
    assertEquals("foo", item.name);
  }

  @Test
  void systemLowersValues() {
    Item item = createAndUpdate(15, 25);
    assertEquals(14, item.sellIn);
    assertEquals(24, item.quality);
  }

  @Test
  void qualityDegradesTwiceAsFast() {
    Item item = createAndUpdate(0, 17);
    assertEquals(15, item.quality);
  }

  @Test
  void qualityIsNeverNegative() {
    Item item = createAndUpdate(0, 0);
    assertEquals(0, item.quality);
  }
}