package org.maptalks.poi.animation.in;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSimpleShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.maptalks.poi.animation.MoveDirection;
import org.maptalks.poi.animation.XSLFAnimation;
import org.maptalks.poi.animation.XSLFAnimationType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Created by wangjun on 16/2/18.
 */
public class FlyInAnimation implements XSLFAnimationType{
    
    private XSLFSimpleShape shape;
    
    private String moveDirection;

    public FlyInAnimation(XSLFSimpleShape shape, String moveDirection) {
        this.shape = shape;
        this.moveDirection = moveDirection;
    }
    
    public Element toXml(Document document, XSLFAnimation animation) throws XmlException, ParserConfigurationException {
        String spid = Integer.toString(this.shape.getShapeId());
        Element firstElement = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:par");
        /**
         * <p:par>
         *  <p:cTn id="3" fill="hold">
         */
        Element element1 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cTn");
        element1.setAttribute("id", animation.getElementIdStr());
        element1.setAttribute("fill", "hold");
        
        /**
         * 
          <p:stCondLst>
            <p:cond delay="indefinite"/>
          </p:stCondLst>
          <p:childTnLst>
         */
        Element element2 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:stCondLst");
        Element element3 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cond");
        element3.setAttribute("delay", "indefinite");
        element2.appendChild(element3);
        element1.appendChild(element2);
        /**
         * 
            <p:par>
              <p:cTn id="4" fill="hold">
                <p:stCondLst>
                  <p:cond delay="0"/>
                </p:stCondLst>
         */

        Element childList1 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:childTnLst");
        
        Element element4 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:par");
        Element element5 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cTn");
        element5.setAttribute("id", animation.getElementIdStr());
        element5.setAttribute("fill", "hold");

        Element element6 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:stCondLst");
        Element element7 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cond");
        element7.setAttribute("delay", "0");
        element6.appendChild(element7);
        element5.appendChild(element6);
        element4.appendChild(element5);
        childList1.appendChild(element4);
        element1.appendChild(childList1);
        
        /**
         * <p:childTnLst>
              <p:par>
                <p:cTn id="5" presetID="2" presetClass="entr" presetSubtype="8" fill="hold" nodeType="clickEffect">
                  <p:stCondLst>
                    <p:cond delay="0"/>
                  </p:stCondLst>
                  <p:childTnLst>
         */
        Element childList2 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:childTnLst");
        Element element21 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:par");
        Element element22 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cTn");
        element22.setAttribute("id", animation.getElementIdStr());
        element22.setAttribute("presetID", spid);
        element22.setAttribute("presetClass", "entr");
        element22.setAttribute("presetSubtype", "8");
        element22.setAttribute("fill", "hold");
        element22.setAttribute("nodeType", "clickEffect");
        
        Element element23 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:stCondLst");
        Element element24 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cond");
        element24.setAttribute("delay", "0");
        element23.appendChild(element24);
        element22.appendChild(element23);
        element21.appendChild(element22);
        childList2.appendChild(element21);
        
        Element childList3 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:childTnLst");
        Element pSet = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:set");
        Element pcBhvr = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cBhvr");
        Element element31 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cTn");
        element31.setAttribute("id", animation.getElementIdStr());
        element31.setAttribute("fill", "hold");
        element31.setAttribute("dur", "1");
        Element element32 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:stCondLst");
        Element element33 = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cond");
        element33.setAttribute("delay", "0");
        element32.appendChild(element33);
        element31.appendChild(element32);
        pcBhvr.appendChild(element31);
        

        Element pTgtEl = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:tgtEl");
        Element pSpTgt = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:spTgt");
        pSpTgt.setAttribute("spid", spid);//shapeId
        pTgtEl.appendChild(pSpTgt);
        pcBhvr.appendChild(pTgtEl);
        
        Element attrNameLst = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:attrNameLst");
        Element attrName = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:attrName");
        Text text = document.createTextNode("style.visibility");
        attrName.appendChild(text);
        attrNameLst.appendChild(attrName);
        pcBhvr.appendChild(attrNameLst);
        
        Element pTo = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:to");
        Element pStrVal = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:strVal");
        pStrVal.setAttribute("val", "visible");
        pTo.appendChild(pStrVal);
        pSet.appendChild(pcBhvr);
        pSet.appendChild(pTo);
        childList3.appendChild(pSet);
        
        childList3.appendChild(createAnimationXml(animation,document, spid, "ppt_x"));
        childList3.appendChild(createAnimationXml(animation,document, spid, "ppt_y"));
        element22.appendChild(childList3);
        element5.appendChild(childList2);
        firstElement.appendChild(element1);
//        root.appendChild(firstElement);
        return firstElement;
    }
    
    public Element createAnimationXml(XSLFAnimation animation,Document document, String spid, String locTag) {
        Element panim = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:anim");
        panim.setAttribute("calcmode", "lin");
        panim.setAttribute("valueType", "num");
        
        Element pcBhvr = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cBhvr");
        pcBhvr.setAttribute("additive", "base");
        Element pcTn = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:cTn");
        pcTn.setAttribute("id", animation.getElementIdStr());
        pcTn.setAttribute("dur", "500");
        pcTn.setAttribute("fill", "hold");
        pcBhvr.appendChild(pcTn);
        
        Element pTgtEl = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:tgtEl");
        Element pSpTgt = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:spTgt");
        pSpTgt.setAttribute("spid", spid);//shapeId
        pTgtEl.appendChild(pSpTgt);
        pcBhvr.appendChild(pTgtEl);
        
        Element attrNameLst = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:attrNameLst");
        Element attrName = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:attrName");
        Text text = document.createTextNode(locTag);
        attrName.appendChild(text);
        attrNameLst.appendChild(attrName);
        pcBhvr.appendChild(attrNameLst);
        panim.appendChild(pcBhvr);
        
        Element ptavLst = document.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:tavLst");
        String startLoc = this.getStartLocation(locTag);
        String endLoc = this.getEndLocation(locTag);
        ptavLst.appendChild(createShapeLocation(document, "0", startLoc));
        ptavLst.appendChild(createShapeLocation(document, "100000", endLoc));
        panim.appendChild(ptavLst);
        return panim;
    }
    
    private String getStartLocation(String locTag) {
        String result = new String("");
        if(this.moveDirection.equals(MoveDirection.LEFT)) {
            if(locTag.equals("ppt_x")) {
                result = "0-#ppt_w";
            } else {
                result = "#ppt_y";
            } 
        } else if(this.moveDirection.equals(MoveDirection.RIGHT)) {
            if(locTag.equals("ppt_x")) {
                result = "#ppt_w";
            } else {
                result = "#ppt_y";
            }
        }  else if(this.moveDirection.equals(MoveDirection.TOP)) {
            if(locTag.equals("ppt_x")) {
                result = "#ppt_x";
            } else {
                result = "0-#ppt_h";
            }
        }  else if(this.moveDirection.equals(MoveDirection.BOTTOM)) {
            if(locTag.equals("ppt_x")) {
                result = "#ppt_x";
            } else {
                result = "#ppt_h";
            }
        } 
        return result;
    }
    
    private String getEndLocation(String locTag) {
        String result = new String("");
        if(locTag.equals("ppt_x")) {
            result = "#ppt_x";
        } else {
            result = "#ppt_y";
        }
        return result;
    }
    
    /**
     * <p:tav tm="0">
          <p:val>
            <p:strVal val="#ppt_w"/>
          </p:val>
        </p:tav>
     *
     * @param tm
     * @param location
     * @return
     */
    public Element createShapeLocation(Document doc, String tm, String location) {
        Element ptav = doc.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:tav");
        ptav.setAttribute("tm", tm);
        Element pval = doc.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:val");
        Element pstrVal = doc.createElementNS("http://schemas.openxmlformats.org/presentationml/2006/main","p:strVal");
        pstrVal.setAttribute("val", location);
        pval.appendChild(pstrVal);
        ptav.appendChild(pval);
        return ptav;
    }

}
