<#import "/macros/template.ftlh" as template/>
<#assign contextRoot>${rc.contextPath}</#assign>
<@template.render pagetitle=family.familyName pageMetadata="foo">
	<div>
		<h2>Family Members</h2>
		<p>Add your family so everybody gets their own sign-in and profile.</p>

		<div class="row">
			<div class="list-group">
				<#list family.familyMembers as familyMember>
					<#if familyMember.familyMemberType == 'PARENT'><#assign css='panel-primary'/><#else/><#assign css='panel-info'/></#if>
					<#if familyMember.familyMemberType == 'PARENT'><#assign glyph='fa-user-secret'/><#else/><#assign glyph='fa-child'/></#if>
					<div class="col-md-4 family-member">
						<a href="${contextRoot}/auth/view-member/${familyMember.user.id}">
							<div class="panel ${css}">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa ${glyph}" style="float: right"></i> ${familyMember.user.firstname} ${familyMember.user.lastname}
									</h3>
								</div>
								<div class="panel-body">
									<dl>
										<dt>Current balance:</dt>
										<dd>$${familyMember.meritAccount.balance?string["0.00"]}</dd>
										
										<dt>Total spent:</dt>
										<dd>$${0?string["0.00"]}</dd>
									</dl>
								</div>
							</div>
						</a>
					</div>
				</#list>
			</div>
		</div>		
		
		<button href="#" class="btn btn-primary btn-lg"><i class="fa fa-users fa-fw"></i> Add a family member</button>
	</div>

	<hr/>

	<div>
		<h3>Other People</h3>
		<p>
			Allow people who are not a part of your immediate family to sign-in with their own accounts. Although they will not be listed
			as family members, they can approve rewards for your children.
		</p>

		<button href="#" class="btn btn-primary btn-lg"><i class="fa fa-users fa-fw"></i> Add another person</button>
	</div>
</@template.render>