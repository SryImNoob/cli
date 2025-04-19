package com.han.app;

import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.mu.util.stream.BiCollectors;
import com.google.mu.util.stream.BiStream;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor editor = injector.getInstance(TextEditor.class);
        editor.makeSpellCheck();
        ImmutableList<String> words = ImmutableList.of("1", "2", "3");
        Map<Integer, String> map = BiStream.biStream(words)
                .mapKeys(str -> Integer.parseInt(str) + 1).collect(BiCollectors.toMap());
        System.out.println(map);
    }
}
