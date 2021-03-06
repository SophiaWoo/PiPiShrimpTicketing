package com.ppshrimp.filmsystem.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppshrimp.filmsystem.persistence.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<User>  findAll() {
    	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (List<User>)criteria.list();
    }
    
    public User findOne(String username) {
        String hql = "from User u where u.username=?";  // User为实体名而不是数据表中的名字
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, username);  
        return (User)query.uniqueResult();  
    	
    }
    
    public int addOne(User user) {
    	Long integer = (Long)sessionFactory.getCurrentSession().save(user);
    	System.out.println(user.toString());
        return integer.intValue();
    }
    
    public int deleteOne(String username) {
    	return 0;
    }
}
