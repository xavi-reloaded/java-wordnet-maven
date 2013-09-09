package com.apiumtech.wordnet;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xavi
 * Date: 9/8/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class JWNLWrapperTest {

    private JWNLWrapper sut;

    @BeforeMethod
    public void setUp() throws Exception {
        sut = new JWNLWrapper();
    }

    @Test
    public void test_getHyponymListFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getHyponymList(word);
        String expected = "[puppy, pooch, doggie, doggy, barker, bow-wow, cur, mongrel, mutt, lapdog, toy_dog, toy, hunting_dog, working_dog, dalmatian, coach_dog, carriage_dog, basenji, pug, pug-dog, Leonberg, Newfoundland, Newfoundland_dog, Great_Pyrenees, spitz, griffon, Brussels_griffon, Belgian_griffon, corgi, Welsh_corgi, poodle, poodle_dog, Mexican_hairless]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getHypernymListFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getHypernymList(word);
        String expected = "[canine, canid, domestic_animal, domesticated_animal]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getHolonymsFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getHolonyms(word);
        String expected = "[Canis, genus_Canis, pack]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getAntonimsListFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getAntonymsList(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getSynonymListFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getSynomimsList(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getAlsoSeesFromWord_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getAlsoSees(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getAttributes_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getAttributes(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getMeronyms_existing() throws Exception {
        String word = "dog";
        List<String> actual = sut.getMeronyms(word);
        String expected = "[flag]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
     public void test_getCauses() throws Exception {
        String word = "dog";
        List<String> actual = sut.getCauses(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void test_getDerived() throws Exception {
        String word = "dog";
        List<String> actual = sut.getDerived(word);
        String expected = "[]";
        Assert.assertEquals(actual.toString(),expected);
    }

}
