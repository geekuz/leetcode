package designPatterns.iterator.iterators;

import designPatterns.iterator.profiles.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
