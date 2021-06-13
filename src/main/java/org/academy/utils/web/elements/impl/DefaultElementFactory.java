package org.academy.utils.web.elements.impl;

import org.academy.utils.web.elements.ElementFactory;
import org.academy.utils.web.elements.elements.Element;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

public class DefaultElementFactory implements ElementFactory {
    @Override
    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends Element> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
