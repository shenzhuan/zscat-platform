package com.zscat.platform.shop;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.common.utils.IPUtils;
import com.zscat.common.utils.PageUtils;
import com.zscat.common.utils.Query;
import com.zscat.common.utils.R;
import com.zscat.goods.entity.*;
import com.zscat.goods.service.*;
import com.zscat.order.service.TGoodSorderService;
import com.zscat.order.service.TOrderService;
import com.zscat.platform.config.MemberUtils;
import com.zscat.user.entity.CouponDO;
import com.zscat.user.entity.FavoriteDO;
import com.zscat.user.entity.TMemberDO;
import com.zscat.user.service.CouponService;
import com.zscat.user.service.FavoriteService;
import com.zscat.user.service.TMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-05-17
 */
@Controller
@RequestMapping("diaShop")
public class DiaShopController {
    private String PREFIX = "/diaShop/";
    String path ="F:/zscat-b2b2c/";

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TBrandService tBrandService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TGoodsTypeService tGoodsTypeService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TGoodsService tGoodsService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TGoodsClassService tGoodsClassService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TStoreService tStoreService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private BannerService bannerService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private CouponService couponService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TCartService tCartService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TMemberService tMemberService;

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private AddressService addressService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private FavoriteService favoriteService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TOrderService orderService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TGoodSorderService tGoodSorderService;

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TMemberService userService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private UserJfgoodsService userJfgoodsService;
    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TFloorService tFloorService;
    @ModelAttribute
    public void init(HttpServletRequest request, Model model) {
        TMemberDO user = MemberUtils.getSessionLoginUser();
        if(user!=null){
            Map<String, Object> param =new HashMap<>();
            param.put("userid",MemberUtils.getSessionLoginUser().getId());
            List<TCartDO> cartList=tCartService.list1(param);
            model.addAttribute("cartList", cartList);
            model.addAttribute("totalprice",tCartService.countprice(param));
            model.addAttribute("user",user);
            model.addAttribute("cartCount",tCartService.selectOwnCart(user.getId()));
        }else {
            model.addAttribute("cartList", new ArrayList<TCartDO>());
            model.addAttribute("totalprice",0);
            model.addAttribute("user",user);
            model.addAttribute("cartCount",0);
        }

    }
    /**
     * 获取用户信息
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public @ResponseBody
    R session(HttpServletRequest req) throws Exception {
        R r=new R();
        TMemberDO user=MemberUtils.getSessionLoginUser();
        try {
            if(user!=null){
                r.put("user",user);
                r.put("username",user.getUsername());
                r.put("cartCount",tCartService.selectOwnCart(user.getId()));
            }else{
                return R.error();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return r;
    }
    /**
     * 跳转到首页
     */
    @RequestMapping("index")
    public String index(Model model) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("pid",1);
            params.put("limit",6);
            Query query =new Query(params);
            List<TGoodsClassDO> goodsClassList = tGoodsClassService.list(query);
            for(TGoodsClassDO gc: goodsClassList){
                query =new Query(params);
                query.put("pid",gc.getId());
                query.put("limit",4);
                List<TGoodsClassDO> childs = tGoodsClassService.list(query);
                if(childs!=null && childs.size()>0){
                    gc.setChilds(childs);
                }else{
                    gc.setChilds(null);
                }
                for(TGoodsClassDO gc1: childs){
                    query =new Query(params);
                    query.put("pid",gc1.getId());
                    query.put("limit",15);
                    List<TGoodsClassDO> childs1 = tGoodsClassService.list(query);
                    if(childs!=null && childs.size()>0){
                        gc1.setChilds(childs1);
                    }else{
                        gc1.setChilds(null);
                    }
                }
            }
            model.addAttribute("goodsClassList", goodsClassList);
            Map<String, Object> params1 = new HashMap<>();
            params = new Query(params1);
            params.put("limit", 4);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
            params = new Query(params1);
            params.put("limit", 6);
            params.put("sort","clickHit");
            params.put("order","desc");
            model.addAttribute("hitList", tGoodsService.list1(params));
            params = new Query(params1);
            params.put("limit", 8);
            params.put("sort","create_date");
            params.put("order","desc");
            model.addAttribute("xinpinList", tGoodsService.list1(params));

            params = new Query(params1);
            params.put("limit", 16);
            model.addAttribute("brandList", tBrandService.list(params));

            params = new Query(params1);
            params.put("limit", 5);
            params.put("storeid", 4);
            model.addAttribute("bannerList", bannerService.list(params));

            List<TFloorDO> floorList = tFloorService.list(null);
            int i=0;
            for (TFloorDO floorDO:floorList){
                List<TGoodsDO> goodsList = tGoodsService.getProductByFloorid(floorDO.getId());
                floorDO.setGoodsList(goodsList);
                floorDO.setBrandList(tBrandService.getBrandByFloorid(floorDO.getId()));
                params = new Query(params1);
                params.put("limit", 8);
                params.put("pid", floorDO.getParentId());
                floorDO.setGoodsClassList(tGoodsClassService.list(params));
                if(i==0){
                    params = new Query(params1);
                    params.put("limit", 6);
                    params.put("sort","create_date");
                    params.put("order","desc");
                    floorDO.setGoodsList1(tGoodsService.list1(params));
                    floorDO.setParentIds("最新商品");
                }else if(i==1){
                    params = new Query(params1);
                    params.put("limit", 6);
                    params.put("sort","clickHit");
                    params.put("order","desc");
                    floorDO.setParentIds("最爱商品");
                    floorDO.setGoodsList1(tGoodsService.list1(params));
                }else if(i==2){
                    params = new Query(params1);
                    params.put("sort","sellhit");
                    params.put("order","desc");
                    params.put("limit", 6);
                    floorDO.setParentIds("热卖商品");
                    floorDO.setGoodsList1(tGoodsService.list1(params));
                }else if(i==3){
                    params = new Query(params1);
                    params.put("sort","replyhit");
                    params.put("order","desc");
                    params.put("limit", 6);
                    floorDO.setParentIds("争议商品");
                    floorDO.setGoodsList1(tGoodsService.list1(params));
                }else if(i==4){
                    params = new Query(params1);
                    params.put("limit", 6);
                    params.put("iscom","1");
                    floorDO.setParentIds("推荐商品");
                    floorDO.setGoodsList1(tGoodsService.list1(params));
                }
                i++;
            }
            model.addAttribute("floorList", floorList);
            params = new Query(params1);
            params.put("limit", 8);
            model.addAttribute("home", "1");
        }catch (Exception e){
            e.printStackTrace();
        }
        return PREFIX + "index";
    }

    /**
     * 跳转到搜索
     */
    @RequestMapping("search")
    public String search(Model model,HttpServletRequest req) {
        try {
            Map<String, Object> param = new HashMap<>();
            String keyword =req.getParameter("keyword");
            if (keyword!=null){
                //  PageUtils data = luceneService.page(1,15,keyword);
                //  model.addAttribute("data",data);
            }else{
                model.addAttribute("data",new PageUtils(new ArrayList<>(),0));
            }

            Query params = new Query(param);
            params.put("limit", 5);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
            model.addAttribute("typeList", tGoodsTypeService.list(null));
            model.addAttribute("brandList", tBrandService.list(null));
            params = new Query(param);
            params.put("limit", 15);
            params.put("sort","sellHit");
            params.put("order","desc");
            model.addAttribute("sellList", tGoodsService.list1(params));
            params = new Query(param);
            params.put("limit", 3);
            params.put("sort","create_date");
            params.put("order","desc");
            model.addAttribute("xinpinList", tGoodsService.list1(params));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PREFIX + "search";
    }
    /**
     * 跳转到团购
     */
    @RequestMapping("groupList")
    public String groupList(Model model,HttpServletRequest req) {
        try {
            Map<String, Object> param = new HashMap<>();
            Query params = new Query(param);
            params.put("limit", 16);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PREFIX + "groupList";
    }
    /**
     * 跳转到团购
     */
    @RequestMapping("daySee")
    public String daySee(Model model,HttpServletRequest req) {
        try {
            Map<String, Object> param = new HashMap<>();
            Query params = new Query(param);
            params.put("limit", 16);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PREFIX + "daySee";
    }
    /**
     * 跳转到去反馈
     */
    @RequestMapping("Feedback")
    public String Feedback(Model model,HttpServletRequest req) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return PREFIX + "Feedback";
    }

    /**
     * 跳转到商品详情
     */
    @RequestMapping("/goodsDetail/{id}")
    public String goodsDetail(@PathVariable Long id, Model model, HttpServletRequest request, HttpServletResponse resp) {
        TGoodsDO goods = tGoodsService.get(id);
        TMemberDO TMemberDO =MemberUtils.getSessionLoginUser();
        if (TMemberDO!=null){
            Map<String, Object> params = new HashMap<>();
            params.put("userid",TMemberDO.getId());
            params.put("goodsid",id);
            params.put("deletestatus",2);
            params.put("type",1);
            FavoriteDO favoriteDO = favoriteService.selectOne(params);
            if(favoriteDO!=null){
                goods.setIs_favorite(1);
            }else{
                goods.setIs_favorite(2);
            }
        }else{
            goods.setIs_favorite(2);
        }
        String ip = IPUtils.getIpAddr(request);
       /* TGoodsDO goodsR = new TGoodsDO(goods.getId(), goods.getTitle(), goods.getImg(), goods.getPrices());
        RedisHashUtil.hset(RedisConstant.SHOPPING_HISTORY + ip, id + "", JSONUtils.beanToJson(goodsR), 24 * 60 * 60);
        model.addAttribute("goods",goods);
       */
        if (goods.getImgmore() != null && goods.getImgmore().indexOf(",") > -1) {
            model.addAttribute("imgs", goods.getImgmore().split(","));
        }
        goods.setClickhit(goods.getClickhit()+1);
        tGoodsService.update(goods);
        Map<String, Object> params1 = new HashMap<>();
        Query params = new Query(params1);
        params.put("limit", 5);
        params.put("iscom","1");
        model.addAttribute("commList", tGoodsService.list1(params));

//        params = new Query(params1);
//        params.put("limit", 6);
//        params.put("brandid",goods.getBrandid());
//        model.addAttribute("brandList", tGoodsService.list1(params));

        params = new Query(params1);
        params.put("limit", 4);
        params.put("typeid",goods.getTypeid());
        model.addAttribute("typeList", tGoodsService.list1(params));

        params = new Query(params1);
        params.put("limit", 6);
        params.put("classid",goods.getClassid());
        model.addAttribute("classList", tGoodsService.list1(params));
        List<TGoodsDO> viewGoodslist = new ArrayList<>();

        /*Map<String, String> map = RedisHashUtil.hgetAll(RedisConstant.SHOPPING_HISTORY + ip);

        List<String> sList = JSONSerializerUtil.testMap2List(map);
        for (int i = 0; i < sList.size(); i++) {
            String json = sList.get(i);
            viewGoodslist.add(JsonUtils.fromJson(json, TGoodsDO.class));
        }*/
        model.addAttribute("viewGoodslist", viewGoodslist);
        model.addAttribute("goods", goods);

//        params = new Query(params1);
//        params.put("limit", 60);
//        params.put("goodsid",goods.getId());
//        model.addAttribute("replyList", tReplyService.list(params));
        return PREFIX + "goodsDetail";
    }

    /**
     * 跳转到积分商城
     */
    @RequestMapping("jfindex")
    public String jifen(Model model) {
        try {
            Map<String, Object> params = new HashMap<>();

            Map<String, Object> params1 = new HashMap<>();
            params = new Query(params1);
            params.put("limit", 8);

            //   model.addAttribute("jfList", jifengoodsService.list(params));

        }catch (Exception e){
            e.printStackTrace();
        }
        return PREFIX + "jfindex";
    }

    /**
     * 跳转到优惠劵
     */
    @RequestMapping("youhuijuan")
    public String youhuijuan(Model model) {
        try {
            TMemberDO user = MemberUtils.getSessionLoginUser();
            if(user!=null){
                model.addAttribute("username", user.getUsername());
                model.addAttribute("cartCount", tCartService.selectOwnCart(user.getId()));
            }
            Map<String, Object> params = new HashMap<>();

            Map<String, Object> params1 = new HashMap<>();
            params = new Query(params1);
            params.put("limit", 8);
            List<CouponDO> couponList = couponService.list(params);
            model.addAttribute("couponList", couponList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return PREFIX + "youhuijuan";
    }

    /**
     * 跳转到店铺详情
     */
    @RequestMapping("/store/{id}")
    public String store(@PathVariable Long id, Model model) {
        TStoreDO store = tStoreService.get(id);
        model.addAttribute("store",store);

        return PREFIX + "store";
    }

    /**
     * 根据品牌查询商品
     */
    @RequestMapping("/goodsByBrand/{id}")
    public String brand(@PathVariable Long id, Model model) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("limit", 5);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
            model.addAttribute("typeList", tGoodsTypeService.list(null));
            model.addAttribute("brandList", tBrandService.list(null));
            params = new Query(params);
            params.put("limit", 15);
            params.put("sort","sellHit");
            params.put("order","desc");
            model.addAttribute("sellList", tGoodsService.list1(params));
            params = new Query(params);
            params.put("limit", 3);
            params.put("sort","create_date");
            params.put("order","desc");
            model.addAttribute("xinpinList", tGoodsService.list1(params));
            if(StringUtils.isNotEmpty(id+"")){
                params.put("brandid",id);
            }

            params.put("limit",16);
            Query query =new Query(params);
            model.addAttribute("goodsList", tGoodsService.list1(query));
        }catch (Exception e){
            e.printStackTrace();
        }
        return PREFIX + "goodsList";
    }

    /**
     * 根据品牌查询商品
     */
    @RequestMapping("/goodsByClass/{id}")
    public String goodsByClass(@PathVariable Long id, Model model) {
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("limit", 5);
            params.put("iscom","1");
            model.addAttribute("commList", tGoodsService.list1(params));
            model.addAttribute("typeList", tGoodsTypeService.list(null));
            model.addAttribute("brandList", tBrandService.list(null));
            params = new Query(params);
            params.put("limit", 15);
            params.put("sort","sellHit");
            params.put("order","desc");
            model.addAttribute("sellList", tGoodsService.list1(params));
            params = new Query(params);
            params.put("limit", 3);
            params.put("sort","create_date");
            params.put("order","desc");
            model.addAttribute("xinpinList", tGoodsService.list1(params));
            if(StringUtils.isNotEmpty(id+"")){
                params.put("classid",id);
            }
            params.put("limit",16);
            Query query =new Query(params);
            model.addAttribute("goodsList", tGoodsService.list1(query));
        }catch (Exception e){
            e.printStackTrace();
        }
        return PREFIX + "goodsList";
    }



    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        if( MemberUtils.getSessionLoginUser() != null){
            return "redirect:/diaShop/index";
        }
        return PREFIX + "login";
    }

    /**
     * 登录验证
     * @param
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            return R.ok();
        } catch (Exception e) {
            return R.error("用户或密码错误");
        }
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String reg() {
        if( MemberUtils.getSessionLoginUser() != null){
            return "redirect:/diaShop/index";
        }
        return PREFIX + "zhuce";
    }

    @RequestMapping(value = "reg", method = RequestMethod.POST)
    public @ResponseBody R reg(
            @RequestParam(value = "password",required=true)String  password,
            @RequestParam(value = "username",required=true)String username,
            @RequestParam(value = "passwordRepeat",required=true)String passwordRepeat,HttpServletRequest request) {
        Map<String, Object> msg = new HashMap<String, Object>();
        if (!StringUtils.equalsIgnoreCase(password, passwordRepeat)) {
            return R.error("密码不一致！");
        }
        String secPwd = null ;

        TMemberDO m=new TMemberDO();
        m.setUsername(username);
        Map mapU =new HashMap();
        mapU.put("username",username);
        int count = userService.count(mapU);
        m.setStatus(1);
        // m.setJifen(Constan.REGISTER.getCode());
        m.setPassword(secPwd);
        m.setAddtime(new Date());
        m.setBalance(1000);//余额
        m.setImg("http://p0bt2oaom.bkt.clouddn.com/AD-02.jpg");
        try {
            if (count>0){
                return R.error("用户已存在");
            }
            int result = userService.save(m);
            if (result>0) {

            } else {
                return R.error("用户或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok();
    }
    /**
     * 用户退出
     *
     * @return 跳转到登录页面
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        // ShiroUtils.logout();
        return "redirect:/diaShop/index";
    }


    /**
     * 通过菜单类别
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/goodsList")
    public ModelAndView goodsList(HttpServletRequest request, HttpServletResponse resp)throws Exception{
        ModelAndView mav=new ModelAndView();

        Map<String, Object> params1 = new HashMap<>();
        params1.put("limit", 8);
        String offset = request.getParameter("offset");
        if(StringUtils.isNotEmpty(offset)){
            params1.put("offset", offset);
        }
        Query query = new Query(params1);
        List<TGoodsDO> tGoodsList = tGoodsService.list1(query);
        int total = tGoodsService.count(query);
        PageUtils pageUtils = new PageUtils(tGoodsList, total);
        mav.addObject("pageUtils", pageUtils);
        mav.addObject("typeList", tGoodsTypeService.list(null));
        Query params = new Query(params1);
        params.clear();
        params = new Query(params1);
        params.put("limit", 2);
        params.put("iscom","1");
        mav.addObject("commList", tGoodsService.list1(params));
        params.clear();
        params = new Query(params1);
        params.put("limit", 6);
        params.put("sort","sellhit");
        params.put("order","desc");
        mav.addObject("sellList", tGoodsService.list1(params));
        mav.setViewName("web/goodsList");
        return mav;
    }

    /**
     * 通过菜单类别
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/brandList")
    public ModelAndView brandList(HttpServletRequest request, HttpServletResponse resp)throws Exception{
        ModelAndView mav=new ModelAndView();
        Map<String, Object> params1 = new HashMap<>();
        mav.addObject("brandList", tBrandService.list(null));
        Query params = new Query(params1);
        params.clear();
        params = new Query(params1);
        params.put("limit", 6);
        params.put("sort","sellhit");
        params.put("order","desc");
        mav.addObject("sellList", tGoodsService.list1(params));
        mav.setViewName("diaShop/brandList");
        return mav;
    }
}
