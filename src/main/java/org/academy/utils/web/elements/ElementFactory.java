package org.academy.utils.web.elements;

import org.academy.utils.web.elements.elements.Element;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);

}
