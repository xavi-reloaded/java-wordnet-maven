package com.apiumtech.wordnet;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.data.list.PointerTargetTree;
import net.didion.jwnl.data.list.PointerTargetTreeNode;
import net.didion.jwnl.data.list.PointerTargetTreeNodeList;
import net.didion.jwnl.dictionary.Dictionary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xavi
 * Date: 9/8/13
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class JWNLWrapper {

    public JWNLWrapper() {
        try {
            // initialize JWNL (this must be done before JWNL can be used)
            String fileProperties = JWNLWrapper.class.getResource("/config/file_properties.xml").getPath();
            JWNL.initialize(new FileInputStream(fileProperties));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public List<String> getHyponymList(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);

        PointerTargetTree hyponyms = PointerUtils.getInstance().getHyponymTree(sense);
        PointerTargetTreeNodeList list = hyponyms.getRootNode().getChildTreeList();

        List<String> result = getSerializedJWNLresult(list);
        return result;
    }

    public List<String> getHypernymList(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList hypernyms = PointerUtils.getInstance().getDirectHypernyms(sense);
        List<String> result = getJWNLtreeList(hypernyms);
        return result;
    }

    public List<String> getAntonymsList(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getAntonyms(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getSynomimsList(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getSynonyms(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getAlsoSees(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getAlsoSees(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getMeronyms(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getMeronyms(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getAttributes(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getAttributes(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getCauses(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getCauses(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }

    public List<String> getDerived(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getDerived(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }








    public List<String> getHolonyms(String text) throws JWNLException {
        Synset sense = getSynsetFromText(text);
        PointerTargetNodeList antonyms = PointerUtils.getInstance().getHolonyms(sense);
        List<String> result = getJWNLtreeList(antonyms);
        return result;
    }


    private List<String> getJWNLtreeList(PointerTargetNodeList antonyms) {
        PointerTargetTreeNodeList list = antonyms.toTreeList();

        return getSerializedJWNLresult(list);
    }


    private List<String> getSerializedJWNLresult(PointerTargetTreeNodeList list) {
        List<String> result = new ArrayList<String>();
        for ( int x=0; x<list.size(); x++) {
            PointerTargetTreeNode node = (PointerTargetTreeNode)list.get(x);
            for (Word w : node.getSynset().getWords()){
                result.add(w.getLemma());
            }
        }
        return result;
    }


    private Synset getSynsetFromText(String text) throws JWNLException {
        IndexWord word = Dictionary.getInstance().getIndexWord(POS.NOUN, text);
        return word.getSense(1);
    }
}
