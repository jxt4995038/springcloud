//package com.example.order;
//
//import com.google.common.base.Objects;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
///**
// * @program: springcloud
// * @description:
// * @author: jiaxiaotong
// * @create: 2020-02-20 10:57
// */
//public class Bom {
//    //名称
//    private String bomName;
//    //数量
//    private int num;
//    //组件
//    private List<Bom> boms;
//
//    public String getBomName() {
//        return bomName;
//    }
//
//    public void setBomName(String bomName) {
//        this.bomName = bomName;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public List<Bom> getBoms() {
//        return boms;
//    }
//
//    public void setBoms(List<Bom> boms) {
//        this.boms = boms;
//    }
//
//    public static void main(String[] args) {
//        Bom bomB = new Bom();
//        bomB.setBomName("商品B");
//        bomB.setNum(1);
//
//        Bom bomC = new Bom();
//        bomC.setBomName("商品C");
//        bomC.setNum(2);
//
//        Bom bomD = new Bom();
//        bomD.setBomName("商品D");
//        bomD.setNum(1);
//
//        List<Bom> belongA = new ArrayList<>();
//        belongA.add(bomB);
//        belongA.add(bomC);
//        belongA.add(bomD);
//
//        Bom bomA = new Bom();
//        bomA.setBomName("商品A");
//        bomA.setBoms(belongA);
//
//        Bom bomE = new Bom();
//        bomE.setBomName("商品E");
//        bomE.setNum(1);
//
//        Bom bomF = new Bom();
//        bomF.setBomName("商品F");
//        bomF.setNum(2);
//
//        List<Bom> belongB = new ArrayList<>();
//        belongB.add(bomE);
//        belongB.add(bomF);
//        belongB.add(bomA);
//        bomB.setBoms(belongB);
//        boolean b = checkBomDeadLock(bomB);
//        System.out.println(b);
//    }
//
//    public static boolean checkBomDeadLock(Bom bom){
//        List<Bom> allBoms = new ArrayList<>();
//        return loop(allBoms,bom);
//    }
//
//    public static boolean loop(List<Bom> allBoms,Bom bom){
//        if (CollectionUtils.isEmpty(bom.getBoms())) {
//            return false;
//        }
//        List<Bom> boms = bom.getBoms();
//        for (Bom bom1 : boms) {
//            if (allBoms.contains(bom1)) {
//                return true;
//            }else {
//                allBoms.add(bom1);
//                if (loop(allBoms,bom1))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Bom bom = (Bom) o;
//        return Objects.equal(bomName, bom.bomName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(bomName);
//    }
//}