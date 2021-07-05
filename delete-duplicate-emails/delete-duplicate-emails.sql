DELETE p1 FROM Person p1 JOIN Person p2 on p1.Email = p2.Email
WHERE p1.Id > p2.Id; 
